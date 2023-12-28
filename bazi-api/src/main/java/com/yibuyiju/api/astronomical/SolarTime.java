package com.yibuyiju.api.astronomical;

import java.util.ArrayList;
import java.util.List;

/**
 * 真太阳时计算
 * https://github.com/hkargv/paipan/blob/master/lib/class.paipan.php
 *
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 10:03
 */
public class SolarTime {

    /**
     * 标准时间发出地经度(角度表示,东经为正西经为负),北京时间的经度为+120度0分
     */
    private Double J = Double.valueOf(120);
    /**
     * 默认纬度(角度表示,北纬为正南纬为负),这里是中国标准时间发出地(陕西省渭南市蒲城县)
     */
    private Double W = Double.valueOf(120);

    /**
     * 真太阳时模块,sn代表sin
     */
    private Double sn(Double x) {
        return Math.sin(x * 1.74532925199433E-02);
    }

    /**
     * 真太阳时模块,cn代表cosine
     */
    private Double cn(Double x) {
        return Math.cos(x * 1.74532925199433E-02);
    }

    /**
     * 真太阳时模块,返回小数部分(负数特殊) returns fractional part of a number
     */
    private Double fpart(Double x) {
        x = x - Math.floor(x);
        if (x < 0) {
            x = x + 1;
        }
        return x;
    }

    /**
     * 真太阳时模块,只取整数部份
     */
    private Double ipart(Double x) {
        if (x == 0) {
            return Double.valueOf(0);
        }
        return (x / Math.abs(x)) * Math.floor(Math.abs(x));
    }

    /**
     * 真太阳时模块,finds a parabola through three points and returns values of coordinates of extreme value (xe, ye) and zeros if any (z1, z2) assumes that the x values are -1, 0, +1
     */
    private Double[] quad(Double ym, Double y0, Double yp) {
        Double nz = Double.valueOf(0);
        Double A = 0.5 * (ym + yp) - y0;
        Double b = 0.5 * (yp - ym);
        Double c = y0;
        Double xe = -b / (2 * A);
        Double ye = (A * xe + b) * xe + c;
        Double dis = b * b - 4 * A * c;
        Double z1 = Double.valueOf(0), z2 = Double.valueOf(0);

        if (dis > 0) {
            Double dx = 0.5 * Math.sqrt(dis) / Math.abs(A);
            z1 = xe - dx;
            z2 = xe + dx;
            if (Math.abs(z1) <= 1) {
                nz++;
            }
            if (Math.abs(z2) <= 1) {
                nz++;
            }
            if (z1 < -1) {
                z1 = z2;
            }
        }
        return new Double[]{xe, ye, z1, z2, nz};
    }

    /**
     * 真太阳时模块,returns sine of the altitude of either the sun or the moon given the modified julian day of the UT
     *
     * @param jd
     * @param J  经度,东经为正西经为负
     * @param W
     * @param LX 1月亮 2太阳日升日落 3太阳海上微光
     * @return
     */
    private Double sinalt(Double jd, Double J, Double W, Integer LX) {
        Double instant = jd - 2400001;
        Double t = (instant - 51544.5) / 36525;
        Double[] result;

        if (LX == 1) {
            result = moon(t);
        } else {
            result = sun(t);
        }

        Double mjd0 = ipart(instant);
        Double ut = (instant - mjd0) * 24;
        Double t2 = (mjd0 - 51544.5) / 36525;
        Double gmst = 6.697374558 + 1.0027379093 * ut;
        gmst = gmst + (8640184.812866 + (0.093104 - 0.0000062 * t2) * t2) * t2 / 3600;
        Double lmst = 24 * fpart((gmst + J / 15) / 24);
        Double tau = 15 * (lmst - result[0]);

        return sn(W) * sn(result[1]) + cn(W) * cn(result[1]) * cn(tau);
    }

    /**
     * 真太阳时模块,关于太阳的,Returns RA and DEC of Sun to roughly 1 arcmin for few hundred years either side of J2000.0
     */
    private Double[] sun(Double t) {
        Double p2 = 2 * Math.PI;
        Double COSEPS = 0.91748;
        Double SINEPS = 0.39778;
        Double m = p2 * fpart(0.993133 + 99.997361 * t);
        Double dL = 6893 * Math.sin(m) + 72 * Math.sin(2 * m);
        Double L = p2 * fpart(0.7859453 + m / p2 + (6191.2 * t + dL) / 1296000);

        Double sl = Math.sin(L);
        Double x = Math.cos(L);
        Double y = COSEPS * sl;
        Double Z = SINEPS * sl;
        Double rho = Math.sqrt(1 - Z * Z);
        Double dec = (360 / p2) * Math.atan(Z / rho);
        Double ra = (48 / p2) * Math.atan(y / (x + rho));

        if (ra < 0) {
            ra = ra + 24;
        }
        return new Double[]{ra, dec};
    }

    /**
     * 真太阳时模块,关于月球的,Returns RA and DEC of Moon to 5 arc min (ra) and 1 arc min (dec) for a few centuries either side of J2000.0
     * Predicts rise and set times to within minutes for about 500 years in past - TDT and UT time diference may become significant for long times
     */
    private Double[] moon(Double t) {
        Double p2 = 2 * Math.PI;
        Double ARC = 206264.8062;
        Double COSEPS = 0.91748;
        Double SINEPS = 0.39778;

        Double L0 = fpart(0.606433 + 1336.855225 * t); // mean long Moon in revs
        Double L = p2 * fpart(0.374897 + 1325.55241 * t); // mean anomaly of Moon
        Double LS = p2 * fpart(0.993133 + 99.997361 * t); // mean anomaly of Sun
        Double d = p2 * fpart(0.827361 + 1236.853086 * t); // diff longitude sun and moon
        Double F = p2 * fpart(0.259086 + 1342.227825 * t); // mean arg latitude

        // longitude correction terms
        Double dL = 22640 * Math.sin(L) - 4586 * Math.sin(L - 2 * d);
        dL = dL + 2370 * Math.sin(2 * d) + 769 * Math.sin(2 * L);
        dL = dL - 668 * Math.sin(LS) - 412 * Math.sin(2 * F);
        dL = dL - 212 * Math.sin(2 * L - 2 * d) - 206 * Math.sin(L + LS - 2 * d);
        dL = dL + 192 * Math.sin(L + 2 * d) - 165 * Math.sin(LS - 2 * d);
        dL = dL - 125 * Math.sin(d) - 110 * Math.sin(L + LS);
        dL = dL + 148 * Math.sin(L - LS) - 55 * Math.sin(2 * F - 2 * d);

        // latitude arguments
        Double S = F + (dL + 412 * Math.sin(2 * F) + 541 * Math.sin(LS)) / ARC;
        Double h = F - 2 * d;

        // latitude correction terms
        Double N = -526 * Math.sin(h) + 44 * Math.sin(L + h) - 31 * Math.sin(h - L) - 23 * Math.sin(LS + h);
        N = N + 11 * Math.sin(h - LS) - 25 * Math.sin(F - 2 * L) + 21 * Math.sin(F - L);

        Double lmoon = p2 * fpart(L0 + dL / 1296000); // Lat in rads
        Double bmoon = (18520 * Math.sin(S) + N) / ARC; // long in rads

        // convert to equatorial coords using a fixed ecliptic
        Double CB = Math.cos(bmoon);
        Double x = CB * Math.cos(lmoon);
        Double V = CB * Math.sin(lmoon);
        Double C = Math.sin(bmoon);
        Double y = COSEPS * V - SINEPS * C;
        Double Z = SINEPS * V + COSEPS * C;
        Double rho = Math.sqrt(1 - Z * Z);
        Double dec = (360 / p2) * Math.atan(Z / rho); // apparent declination
        Double ra = (48 / p2) * Math.atan(y / (x + rho)); // apparent right ascension

        if (ra < 0) {
            ra = ra + 24;
        }
        return new Double[]{ra, dec};
    }

    /**
     * 真太阳时模块,rise and set(升降计算) [升起时刻(真太阳时),落下时刻(真太阳时),真平太阳时差(仅类型2),升起时刻(标准时间,仅类型2),落下时刻(标准时间,仅类型2)]
     *
     * @param jd
     * @param J  经度,东经为正西经为负
     * @param W
     * @param LX 类型:1月亮;2太阳日升日落;3太阳海上微光
     * @return List<Double>
     */
    private List<Double> risenset(Double jd, Double J, Double W, Integer LX) {
        jd = Double.valueOf(Math.round(jd));
        J = +1 * J;
        W = +1 * W;

        Double noon = Math.round(jd) - J / 360;

        Double[] sinho = new Double[4];
        sinho[1] = sn((double) (8 / 60));
        sinho[2] = sn((double) (-50 / 60));
        sinho[3] = sn((double) -12);

        int rise = 0;
        boolean utrise = false;
        int sett = 0;
        boolean utset = false;

        int hour = 1;
        int zero2 = 0;

        Double ym = sinalt(noon + (hour - 1) / 24, J, W, LX) - sinho[LX];
        int above = (ym > 0) ? 1 : 0;

        do {
            Double y0 = sinalt(noon + (hour + 0) / 24, J, W, LX) - sinho[LX];
            Double yp = sinalt(noon + (hour + 1) / 24, J, W, LX) - sinho[LX];
            Double[] quad = quad(ym, y0, yp);
            Double xe = quad[0];
            Double ye = quad[1];
            Double z1 = quad[2];
            Double z2 = quad[3];
            int nz = quad[4].intValue();

            switch (nz) {
                case 0:
                    break;
                case 1:
                    if (ym < 0) {
                        utrise = true;
                        rise = 1;
                    } else {
                        utset = true;
                        sett = 1;
                    }
                    break;
                case 2:
                    if (ye < 0) {
                        utrise = true;
                        utset = true;
                    } else {
                        utrise = true;
                        utset = true;
                    }
                    rise = 1;
                    sett = 1;
                    zero2 = 1;
                    break;
            }
            ym = yp;
            hour = hour + 2;
        } while (!((hour == 25) || (rise * sett == 1)));

        // 处理返回结果
        List<Double> result = new ArrayList<>();
        // 添加升起和落下时刻
        result.add((utrise ? hour : Double.valueOf(0)));
        result.add((utset ? hour : Double.valueOf(0)));
        // 其他计算结果...
        // 计算时间差、标准时间等其他信息
        return result;
    }


    /**
     * 真太阳时模块,改编自 https://bieyu.com/ (月亮與太陽出没時間) 原理:用天文方法计算出太阳升起和落下时刻,中间则为当地正午(自创),与12点比较得到时差;与寿星万年历比较,两者相差在20秒内
     *
     * @param jd
     * @param J  经度,东经为正西经为负,注意西经60度38分转换方式是: -60 + -1 * 38/60
     * @param W  纬度,北纬为正南纬为负,太阳并不是严格从正东方升起,所以纬度也有影响,只是相对影响较小
     * @return
     */
    public Double zty(Double jd, Double J, Double W) {
        W = (W == null) ? this.W : W;
        List<Double> utriseList = risenset(jd, J, W, 2);
        Double dt = utriseList.get(2);
        // 转地方平太阳时+修正
        return jd - (this.J - J) * 4 / 60 / 24 + dt;
    }
}
