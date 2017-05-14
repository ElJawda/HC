package com.shc.SHC_SS.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllITemes {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("SupervisorStatus")
    @Expose
    private Integer supervisorStatus;
    @SerializedName("UserID")
    @Expose
    private Integer userID;
    @SerializedName("PublishStatus")
    @Expose
    private Integer publishStatus;
    @SerializedName("Favorite")
    @Expose
    private Integer favorite;
    @SerializedName("Priority")
    @Expose
    private Integer priority;
    @SerializedName("CreateDate")
    @Expose
    private String createDate;
    @SerializedName("FamilyID")
    @Expose
    private Integer familyID;
    @SerializedName("Q0991")
    @Expose
    private Integer q0991;
    @SerializedName("Q0992")
    @Expose
    private Integer q0992;
    @SerializedName("Q0994")
    @Expose
    private Integer q0994;
    @SerializedName("Q0995")
    @Expose
    private Integer q0995;
    @SerializedName("Q0996")
    @Expose
    private String q0996;
    @SerializedName("Q0997")
    @Expose
    private String q0997;
    @SerializedName("Q0999a")
    @Expose
    private String q0999a;
    @SerializedName("Q0999b")
    @Expose
    private String q0999b;
    @SerializedName("Q1000x")
    @Expose
    private Double q1000x;
    @SerializedName("Q1000y")
    @Expose
    private Double q1000y;
    @SerializedName("Q4001")
    @Expose
    private Integer q4001;
    @SerializedName("Q4002")
    @Expose
    private Integer q4002;
    @SerializedName("Q4003")
    @Expose
    private Integer q4003;
    @SerializedName("Q4004")
    @Expose
    private Integer q4004;
    @SerializedName("Q4005")
    @Expose
    private Integer q4005;
    @SerializedName("Q4006")
    @Expose
    private Integer q4006;
    @SerializedName("Q4007")
    @Expose
    private Integer q4007;
    @SerializedName("Q4008")
    @Expose
    private Integer q4008;
    @SerializedName("Q4009a")
    @Expose
    private Integer q4009a;
    @SerializedName("Q4009b")
    @Expose
    private Integer q4009b;
    @SerializedName("Q4009c")
    @Expose
    private Integer q4009c;
    @SerializedName("Q4009d")
    @Expose
    private Integer q4009d;
    @SerializedName("Q4009e")
    @Expose
    private Integer q4009e;
    @SerializedName("Q4009f")
    @Expose
    private Integer q4009f;
    @SerializedName("Q4009g")
    @Expose
    private Integer q4009g;
    @SerializedName("Q4009h")
    @Expose
    private Integer q4009h;
    @SerializedName("Q4009i")
    @Expose
    private Integer q4009i;
    @SerializedName("Q4009j")
    @Expose
    private Integer q4009j;
    @SerializedName("Q4009k")
    @Expose
    private Integer q4009k;
    @SerializedName("Q4009l")
    @Expose
    private Integer q4009l;
    @SerializedName("Q4009m")
    @Expose
    private Integer q4009m;
    @SerializedName("Q4010")
    @Expose
    private Integer q4010;
    @SerializedName("Q4011a")
    @Expose
    private Integer q4011a;
    @SerializedName("Q4011b")
    @Expose
    private Integer q4011b;
    @SerializedName("Q4011c")
    @Expose
    private Integer q4011c;
    @SerializedName("Q4011d")
    @Expose
    private Integer q4011d;
    @SerializedName("Q4011e")
    @Expose
    private Integer q4011e;
    @SerializedName("Q4011f")
    @Expose
    private Integer q4011f;
    @SerializedName("Q4011g")
    @Expose
    private Integer q4011g;
    @SerializedName("Q4012")
    @Expose
    private Integer q4012;
    @SerializedName("Q4013")
    @Expose
    private String q4013;
    @SerializedName("Q4013a")
    @Expose
    private Integer q4013a;
    @SerializedName("Q4014a")
    @Expose
    private Integer q4014a;
    @SerializedName("Q4014b")
    @Expose
    private Integer q4014b;
    @SerializedName("Q4014c")
    @Expose
    private Integer q4014c;
    @SerializedName("Q4015")
    @Expose
    private Integer q4015;
    @SerializedName("Q5901")
    @Expose
    private Integer q5901;
    @SerializedName("Q5902")
    @Expose
    private Integer q5902;
    @SerializedName("Q5001")
    @Expose
    private Integer q5001;
    @SerializedName("Q5001a")
    @Expose
    private Integer q5001a;
    @SerializedName("Q5001b")
    @Expose
    private Integer q5001b;
    @SerializedName("Q5001c")
    @Expose
    private Integer q5001c;
    @SerializedName("Q5002")
    @Expose
    private Integer q5002;
    @SerializedName("Q5002a")
    @Expose
    private Integer q5002a;
    @SerializedName("Q5002b")
    @Expose
    private Integer q5002b;
    @SerializedName("Q5002c")
    @Expose
    private Integer q5002c;
    @SerializedName("Q5003")
    @Expose
    private Integer q5003;
    @SerializedName("Q5003a")
    @Expose
    private Integer q5003a;
    @SerializedName("Q5003b")
    @Expose
    private Integer q5003b;
    @SerializedName("Q5003c")
    @Expose
    private Integer q5003c;
    @SerializedName("Q5004")
    @Expose
    private Integer q5004;
    @SerializedName("Q5004a")
    @Expose
    private Integer q5004a;
    @SerializedName("Q5004b")
    @Expose
    private Integer q5004b;
    @SerializedName("Q5004c")
    @Expose
    private Integer q5004c;
    @SerializedName("Q5005")
    @Expose
    private Integer q5005;
    @SerializedName("Q5005a")
    @Expose
    private Integer q5005a;
    @SerializedName("Q5005b")
    @Expose
    private Integer q5005b;
    @SerializedName("Q5005c")
    @Expose
    private Integer q5005c;
    @SerializedName("Q5006")
    @Expose
    private Integer q5006;
    @SerializedName("Q5006a")
    @Expose
    private Integer q5006a;
    @SerializedName("Q5006b")
    @Expose
    private Integer q5006b;
    @SerializedName("Q5006c")
    @Expose
    private Integer q5006c;
    @SerializedName("Q5007")
    @Expose
    private Integer q5007;
    @SerializedName("Q5007a")
    @Expose
    private Integer q5007a;
    @SerializedName("Q5007b")
    @Expose
    private Integer q5007b;
    @SerializedName("Q5007c")
    @Expose
    private Integer q5007c;
    @SerializedName("Q5008")
    @Expose
    private Integer q5008;
    @SerializedName("Q5008a")
    @Expose
    private Integer q5008a;
    @SerializedName("Q5008b")
    @Expose
    private Integer q5008b;
    @SerializedName("Q5008c")
    @Expose
    private Integer q5008c;
    @SerializedName("Q5009")
    @Expose
    private Integer q5009;
    @SerializedName("Q5009a")
    @Expose
    private Integer q5009a;
    @SerializedName("Q5009b")
    @Expose
    private Integer q5009b;
    @SerializedName("Q5009c")
    @Expose
    private Integer q5009c;
    @SerializedName("Q5010")
    @Expose
    private Integer q5010;
    @SerializedName("Q5010a")
    @Expose
    private Integer q5010a;
    @SerializedName("Q5010b")
    @Expose
    private Integer q5010b;
    @SerializedName("Q5010c")
    @Expose
    private Integer q5010c;
    @SerializedName("Q5011")
    @Expose
    private Integer q5011;
    @SerializedName("Q5011a")
    @Expose
    private Integer q5011a;
    @SerializedName("Q5011b")
    @Expose
    private Integer q5011b;
    @SerializedName("Q5011c")
    @Expose
    private Integer q5011c;
    @SerializedName("Q5012")
    @Expose
    private Integer q5012;
    @SerializedName("Q5012a")
    @Expose
    private Integer q5012a;
    @SerializedName("Q5012b")
    @Expose
    private Integer q5012b;
    @SerializedName("Q5012c")
    @Expose
    private Integer q5012c;
    @SerializedName("Q5013")
    @Expose
    private Integer q5013;
    @SerializedName("Q5013a")
    @Expose
    private Integer q5013a;
    @SerializedName("Q5013b")
    @Expose
    private Integer q5013b;
    @SerializedName("Q5013c")
    @Expose
    private Integer q5013c;
    @SerializedName("Q5014")
    @Expose
    private Integer q5014;
    @SerializedName("Q5014a")
    @Expose
    private Integer q5014a;
    @SerializedName("Q5014b")
    @Expose
    private Integer q5014b;
    @SerializedName("Q5014c")
    @Expose
    private Integer q5014c;
    @SerializedName("Q5015")
    @Expose
    private Integer q5015;
    @SerializedName("Q5015a")
    @Expose
    private Integer q5015a;
    @SerializedName("Q5015b")
    @Expose
    private Integer q5015b;
    @SerializedName("Q5015c")
    @Expose
    private Integer q5015c;
    @SerializedName("Q5016")
    @Expose
    private Integer q5016;
    @SerializedName("Q5016a")
    @Expose
    private Integer q5016a;
    @SerializedName("Q5016b")
    @Expose
    private Integer q5016b;
    @SerializedName("Q5016c")
    @Expose
    private Integer q5016c;
    @SerializedName("Q5017")
    @Expose
    private String q5017;
    @SerializedName("Q5017a")
    @Expose
    private Integer q5017a;
    @SerializedName("Q5017b")
    @Expose
    private Integer q5017b;
    @SerializedName("Q5017c")
    @Expose
    private Integer q5017c;
    @SerializedName("Q5017d")
    @Expose
    private Integer q5017d;
    @SerializedName("Q6000")
    @Expose
    private Integer q6000;
    @SerializedName("Q6002")
    @Expose
    private Integer q6002;
    @SerializedName("Q6100")
    @Expose
    private Integer q6100;
    @SerializedName("Q6101")
    @Expose
    private Integer q6101;
    @SerializedName("Q6102")
    @Expose
    private Integer q6102;
    @SerializedName("Q6103")
    @Expose
    private Integer q6103;
    @SerializedName("Q6103a")
    @Expose
    private Integer q6103a;
    @SerializedName("Q6104")
    @Expose
    private Integer q6104;
    @SerializedName("Q6110")
    @Expose
    private Integer q6110;
    @SerializedName("Q6111")
    @Expose
    private Integer q6111;
    @SerializedName("Q6112")
    @Expose
    private Integer q6112;
    @SerializedName("Q6113")
    @Expose
    private Integer q6113;
    @SerializedName("Q6120")
    @Expose
    private Integer q6120;
    @SerializedName("Q6121")
    @Expose
    private Integer q6121;
    @SerializedName("Q6122")
    @Expose
    private Integer q6122;
    @SerializedName("Q6123")
    @Expose
    private Integer q6123;
    @SerializedName("Q6130")
    @Expose
    private Integer q6130;
    @SerializedName("Q6131")
    @Expose
    private Integer q6131;
    @SerializedName("Q6132")
    @Expose
    private Integer q6132;
    @SerializedName("Q6133")
    @Expose
    private Integer q6133;
    @SerializedName("Q6140")
    @Expose
    private Integer q6140;
    @SerializedName("Q6141")
    @Expose
    private Integer q6141;
    @SerializedName("Q6142")
    @Expose
    private Integer q6142;
    @SerializedName("Q6150")
    @Expose
    private Integer q6150;
    @SerializedName("Q6151")
    @Expose
    private Integer q6151;
    @SerializedName("Q6152")
    @Expose
    private Integer q6152;
    @SerializedName("Q6160")
    @Expose
    private Integer q6160;
    @SerializedName("Q6161")
    @Expose
    private Integer q6161;
    @SerializedName("Q6162")
    @Expose
    private Integer q6162;
    @SerializedName("Q6200")
    @Expose
    private Integer q6200;
    @SerializedName("Q6201")
    @Expose
    private Integer q6201;
    @SerializedName("Q6202")
    @Expose
    private Integer q6202;
    @SerializedName("Q6203")
    @Expose
    private Integer q6203;
    @SerializedName("Q6204")
    @Expose
    private Integer q6204;
    @SerializedName("Q6204a")
    @Expose
    private Integer q6204a;
    @SerializedName("Q6205")
    @Expose
    private Integer q6205;
    @SerializedName("Q6210")
    @Expose
    private Integer q6210;
    @SerializedName("Q6211")
    @Expose
    private Integer q6211;
    @SerializedName("Q6212")
    @Expose
    private Integer q6212;
    @SerializedName("Q6220")
    @Expose
    private Integer q6220;
    @SerializedName("Q6221")
    @Expose
    private Integer q6221;
    @SerializedName("Q6222")
    @Expose
    private Integer q6222;
    @SerializedName("Q6223")
    @Expose
    private Integer q6223;
    @SerializedName("Q6230")
    @Expose
    private Integer q6230;
    @SerializedName("Q6231")
    @Expose
    private Integer q6231;
    @SerializedName("Q6232")
    @Expose
    private Integer q6232;
    @SerializedName("Q6233")
    @Expose
    private Integer q6233;
    @SerializedName("Q6240")
    @Expose
    private Integer q6240;
    @SerializedName("Q6241")
    @Expose
    private Integer q6241;
    @SerializedName("Q6242")
    @Expose
    private Integer q6242;
    @SerializedName("Q6250")
    @Expose
    private Integer q6250;
    @SerializedName("Q6251")
    @Expose
    private Integer q6251;
    @SerializedName("Q6252")
    @Expose
    private Integer q6252;
    @SerializedName("Q6300")
    @Expose
    private Integer q6300;
    @SerializedName("Q6301")
    @Expose
    private Integer q6301;
    @SerializedName("Q6302")
    @Expose
    private Integer q6302;
    @SerializedName("Q6303")
    @Expose
    private Integer q6303;
    @SerializedName("Q6304")
    @Expose
    private Integer q6304;
    @SerializedName("Q6305")
    @Expose
    private Integer q6305;
    @SerializedName("Q6306")
    @Expose
    private Integer q6306;
    @SerializedName("Q6307")
    @Expose
    private Integer q6307;
    @SerializedName("Q6308")
    @Expose
    private Integer q6308;
    @SerializedName("Q6309")
    @Expose
    private Integer q6309;
    @SerializedName("Q6310")
    @Expose
    private Integer q6310;
    @SerializedName("Q6311")
    @Expose
    private Integer q6311;
    @SerializedName("Q6312")
    @Expose
    private Integer q6312;
    @SerializedName("Q6313")
    @Expose
    private Integer q6313;
    @SerializedName("Q6400a")
    @Expose
    private Integer q6400a;
    @SerializedName("Q6400b")
    @Expose
    private Integer q6400b;
    @SerializedName("Q6400c")
    @Expose
    private Integer q6400c;
    @SerializedName("Q6400d")
    @Expose
    private Integer q6400d;
    @SerializedName("Q6400e")
    @Expose
    private Integer q6400e;
    @SerializedName("Q6400f")
    @Expose
    private Integer q6400f;
    @SerializedName("Q6400g")
    @Expose
    private Integer q6400g;
    @SerializedName("Q6400h")
    @Expose
    private Integer q6400h;
    @SerializedName("Q6400i")
    @Expose
    private Integer q6400i;
    @SerializedName("Q6400j")
    @Expose
    private String q6400j;
    @SerializedName("Q6401")
    @Expose
    private Integer q6401;
    @SerializedName("Q6600")
    @Expose
    private Integer q6600;
    @SerializedName("Q6001a")
    @Expose
    private Integer q6001a;
    @SerializedName("Q6001b")
    @Expose
    private Integer q6001b;
    @SerializedName("Q6260")
    @Expose
    private Integer q6260;
    @SerializedName("Q6601a")
    @Expose
    private Integer q6601a;
    @SerializedName("Q6601b")
    @Expose
    private Integer q6601b;
    @SerializedName("Q6601c")
    @Expose
    private Integer q6601c;
    @SerializedName("Q6501")
    @Expose
    private Integer q6501;
    @SerializedName("Q6502")
    @Expose
    private Integer q6502;
    @SerializedName("Q6503")
    @Expose
    private Integer q6503;
    @SerializedName("Q6504")
    @Expose
    private Integer q6504;
    @SerializedName("Q6505")
    @Expose
    private Integer q6505;
    @SerializedName("Q6506")
    @Expose
    private Integer q6506;
    @SerializedName("Q6507")
    @Expose
    private Integer q6507;
    @SerializedName("Q6508")
    @Expose
    private Integer q6508;
    @SerializedName("Q6509")
    @Expose
    private Integer q6509;
    @SerializedName("Q6510")
    @Expose
    private Integer q6510;
    @SerializedName("Q6604")
    @Expose
    private Integer q6604;
    @SerializedName("Q6605")
    @Expose
    private Integer q6605;
    @SerializedName("Q6606")
    @Expose
    private Integer q6606;
    @SerializedName("Q6607")
    @Expose
    private Integer q6607;
    @SerializedName("Q6608")
    @Expose
    private Integer q6608;
    @SerializedName("Q6609")
    @Expose
    private Integer q6609;
    @SerializedName("Q6610")
    @Expose
    private Integer q6610;
    @SerializedName("Q6611")
    @Expose
    private Integer q6611;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("family_lat")
    @Expose
    private String lat;
    @SerializedName("family_long")
    @Expose
    private String _long;

    @SerializedName("user_lat")
    @Expose
    private String userLat;
    @SerializedName("deviceId")
    @Expose
    private String userLong;

    @SerializedName("Q0993")
    @Expose
    private List<Q0993> q0993 = null;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getSupervisorStatus() {
        return supervisorStatus;
    }

    public void setSupervisorStatus(Integer supervisorStatus) {
        this.supervisorStatus = supervisorStatus;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getFamilyID() {
        return familyID;
    }

    public void setFamilyID(Integer familyID) {
        this.familyID = familyID;
    }

    public Integer getQ0991() {
        return q0991;
    }

    public void setQ0991(Integer q0991) {
        this.q0991 = q0991;
    }

    public Integer getQ0992() {
        return q0992;
    }

    public void setQ0992(Integer q0992) {
        this.q0992 = q0992;
    }

    public Integer getQ0994() {
        return q0994;
    }

    public void setQ0994(Integer q0994) {
        this.q0994 = q0994;
    }

    public Integer getQ0995() {
        return q0995;
    }

    public void setQ0995(Integer q0995) {
        this.q0995 = q0995;
    }

    public String getQ0996() {
        return q0996;
    }

    public void setQ0996(String q0996) {
        this.q0996 = q0996;
    }

    public String getQ0997() {
        return q0997;
    }

    public void setQ0997(String q0997) {
        this.q0997 = q0997;
    }

    public String  getQ0999a() {
        return q0999a;
    }

    public void setQ0999a(String q0999a) {
        this.q0999a = q0999a;
    }

    public String getQ0999b() {
        return q0999b;
    }

    public void setQ0999b(String q0999b) {
        this.q0999b = q0999b;
    }

    public Double getQ1000x() {
        return q1000x;
    }

    public void setQ1000x(Double q1000x) {
        this.q1000x = q1000x;
    }

    public Double getQ1000y() {
        return q1000y;
    }

    public void setQ1000y(Double q1000y) {
        this.q1000y = q1000y;
    }

    public Integer getQ4001() {
        return q4001;
    }

    public void setQ4001(Integer q4001) {
        this.q4001 = q4001;
    }

    public Integer getQ4002() {
        return q4002;
    }

    public void setQ4002(Integer q4002) {
        this.q4002 = q4002;
    }

    public Integer getQ4003() {
        return q4003;
    }

    public void setQ4003(Integer q4003) {
        this.q4003 = q4003;
    }

    public Integer getQ4004() {
        return q4004;
    }

    public void setQ4004(Integer q4004) {
        this.q4004 = q4004;
    }

    public Integer getQ4005() {
        return q4005;
    }

    public void setQ4005(Integer q4005) {
        this.q4005 = q4005;
    }

    public Integer getQ4006() {
        return q4006;
    }

    public void setQ4006(Integer q4006) {
        this.q4006 = q4006;
    }

    public Integer getQ4007() {
        return q4007;
    }

    public void setQ4007(Integer q4007) {
        this.q4007 = q4007;
    }

    public Integer getQ4008() {
        return q4008;
    }

    public void setQ4008(Integer q4008) {
        this.q4008 = q4008;
    }

    public Integer getQ4009a() {
        return q4009a;
    }

    public void setQ4009a(Integer q4009a) {
        this.q4009a = q4009a;
    }

    public Integer getQ4009b() {
        return q4009b;
    }

    public void setQ4009b(Integer q4009b) {
        this.q4009b = q4009b;
    }

    public Integer getQ4009c() {
        return q4009c;
    }

    public void setQ4009c(Integer q4009c) {
        this.q4009c = q4009c;
    }

    public Integer getQ4009d() {
        return q4009d;
    }

    public void setQ4009d(Integer q4009d) {
        this.q4009d = q4009d;
    }

    public Integer getQ4009e() {
        return q4009e;
    }

    public void setQ4009e(Integer q4009e) {
        this.q4009e = q4009e;
    }

    public Integer getQ4009f() {
        return q4009f;
    }

    public void setQ4009f(Integer q4009f) {
        this.q4009f = q4009f;
    }

    public Integer getQ4009g() {
        return q4009g;
    }

    public void setQ4009g(Integer q4009g) {
        this.q4009g = q4009g;
    }

    public Integer getQ4009h() {
        return q4009h;
    }

    public void setQ4009h(Integer q4009h) {
        this.q4009h = q4009h;
    }

    public Integer getQ4009i() {
        return q4009i;
    }

    public void setQ4009i(Integer q4009i) {
        this.q4009i = q4009i;
    }

    public Integer getQ4009j() {
        return q4009j;
    }

    public void setQ4009j(Integer q4009j) {
        this.q4009j = q4009j;
    }

    public Integer getQ4009k() {
        return q4009k;
    }

    public void setQ4009k(Integer q4009k) {
        this.q4009k = q4009k;
    }

    public Integer getQ4009l() {
        return q4009l;
    }

    public void setQ4009l(Integer q4009l) {
        this.q4009l = q4009l;
    }

    public Integer getQ4009m() {
        return q4009m;
    }

    public void setQ4009m(Integer q4009m) {
        this.q4009m = q4009m;
    }

    public Integer getQ4010() {
        return q4010;
    }

    public void setQ4010(Integer q4010) {
        this.q4010 = q4010;
    }

    public Integer getQ4011a() {
        return q4011a;
    }

    public void setQ4011a(Integer q4011a) {
        this.q4011a = q4011a;
    }

    public Integer getQ4011b() {
        return q4011b;
    }

    public void setQ4011b(Integer q4011b) {
        this.q4011b = q4011b;
    }

    public Integer getQ4011c() {
        return q4011c;
    }

    public void setQ4011c(Integer q4011c) {
        this.q4011c = q4011c;
    }

    public Integer getQ4011d() {
        return q4011d;
    }

    public void setQ4011d(Integer q4011d) {
        this.q4011d = q4011d;
    }

    public Integer getQ4011e() {
        return q4011e;
    }

    public void setQ4011e(Integer q4011e) {
        this.q4011e = q4011e;
    }

    public Integer getQ4011f() {
        return q4011f;
    }

    public void setQ4011f(Integer q4011f) {
        this.q4011f = q4011f;
    }

    public Integer getQ4011g() {
        return q4011g;
    }

    public void setQ4011g(Integer q4011g) {
        this.q4011g = q4011g;
    }

    public Integer getQ4012() {
        return q4012;
    }

    public void setQ4012(Integer q4012) {
        this.q4012 = q4012;
    }

    public String getQ4013() {
        return q4013;
    }

    public void setQ4013(String q4013) {
        this.q4013 = q4013;
    }

    public Integer getQ4013a() {
        return q4013a;
    }

    public void setQ4013a(Integer q4013a) {
        this.q4013a = q4013a;
    }

    public Integer getQ4014a() {
        return q4014a;
    }

    public void setQ4014a(Integer q4014a) {
        this.q4014a = q4014a;
    }

    public Integer getQ4014b() {
        return q4014b;
    }

    public void setQ4014b(Integer q4014b) {
        this.q4014b = q4014b;
    }

    public Integer getQ4014c() {
        return q4014c;
    }

    public void setQ4014c(Integer q4014c) {
        this.q4014c = q4014c;
    }

    public Integer getQ4015() {
        return q4015;
    }

    public void setQ4015(Integer q4015) {
        this.q4015 = q4015;
    }

    public Integer getQ5901() {
        return q5901;
    }

    public void setQ5901(Integer q5901) {
        this.q5901 = q5901;
    }

    public Integer getQ5902() {
        return q5902;
    }

    public void setQ5902(Integer q5902) {
        this.q5902 = q5902;
    }

    public Integer getQ5001() {
        return q5001;
    }

    public void setQ5001(Integer q5001) {
        this.q5001 = q5001;
    }

    public Integer getQ5001a() {
        return q5001a;
    }

    public void setQ5001a(Integer q5001a) {
        this.q5001a = q5001a;
    }

    public Integer getQ5001b() {
        return q5001b;
    }

    public void setQ5001b(Integer q5001b) {
        this.q5001b = q5001b;
    }

    public Integer getQ5001c() {
        return q5001c;
    }

    public void setQ5001c(Integer q5001c) {
        this.q5001c = q5001c;
    }

    public Integer getQ5002() {
        return q5002;
    }

    public void setQ5002(Integer q5002) {
        this.q5002 = q5002;
    }

    public Integer getQ5002a() {
        return q5002a;
    }

    public void setQ5002a(Integer q5002a) {
        this.q5002a = q5002a;
    }

    public Integer getQ5002b() {
        return q5002b;
    }

    public void setQ5002b(Integer q5002b) {
        this.q5002b = q5002b;
    }

    public Integer getQ5002c() {
        return q5002c;
    }

    public void setQ5002c(Integer q5002c) {
        this.q5002c = q5002c;
    }

    public Integer getQ5003() {
        return q5003;
    }

    public void setQ5003(Integer q5003) {
        this.q5003 = q5003;
    }

    public Integer getQ5003a() {
        return q5003a;
    }

    public void setQ5003a(Integer q5003a) {
        this.q5003a = q5003a;
    }

    public Integer getQ5003b() {
        return q5003b;
    }

    public void setQ5003b(Integer q5003b) {
        this.q5003b = q5003b;
    }

    public Integer getQ5003c() {
        return q5003c;
    }

    public void setQ5003c(Integer q5003c) {
        this.q5003c = q5003c;
    }

    public Integer getQ5004() {
        return q5004;
    }

    public void setQ5004(Integer q5004) {
        this.q5004 = q5004;
    }

    public Integer getQ5004a() {
        return q5004a;
    }

    public void setQ5004a(Integer q5004a) {
        this.q5004a = q5004a;
    }

    public Integer getQ5004b() {
        return q5004b;
    }

    public void setQ5004b(Integer q5004b) {
        this.q5004b = q5004b;
    }

    public Integer getQ5004c() {
        return q5004c;
    }

    public void setQ5004c(Integer q5004c) {
        this.q5004c = q5004c;
    }

    public Integer getQ5005() {
        return q5005;
    }

    public void setQ5005(Integer q5005) {
        this.q5005 = q5005;
    }

    public Integer getQ5005a() {
        return q5005a;
    }

    public void setQ5005a(Integer q5005a) {
        this.q5005a = q5005a;
    }

    public Integer getQ5005b() {
        return q5005b;
    }

    public void setQ5005b(Integer q5005b) {
        this.q5005b = q5005b;
    }

    public Integer getQ5005c() {
        return q5005c;
    }

    public void setQ5005c(Integer q5005c) {
        this.q5005c = q5005c;
    }

    public Integer getQ5006() {
        return q5006;
    }

    public void setQ5006(Integer q5006) {
        this.q5006 = q5006;
    }

    public Integer getQ5006a() {
        return q5006a;
    }

    public void setQ5006a(Integer q5006a) {
        this.q5006a = q5006a;
    }

    public Integer getQ5006b() {
        return q5006b;
    }

    public void setQ5006b(Integer q5006b) {
        this.q5006b = q5006b;
    }

    public Integer getQ5006c() {
        return q5006c;
    }

    public void setQ5006c(Integer q5006c) {
        this.q5006c = q5006c;
    }

    public Integer getQ5007() {
        return q5007;
    }

    public void setQ5007(Integer q5007) {
        this.q5007 = q5007;
    }

    public Integer getQ5007a() {
        return q5007a;
    }

    public void setQ5007a(Integer q5007a) {
        this.q5007a = q5007a;
    }

    public Integer getQ5007b() {
        return q5007b;
    }

    public void setQ5007b(Integer q5007b) {
        this.q5007b = q5007b;
    }

    public Integer getQ5007c() {
        return q5007c;
    }

    public void setQ5007c(Integer q5007c) {
        this.q5007c = q5007c;
    }

    public Integer getQ5008() {
        return q5008;
    }

    public void setQ5008(Integer q5008) {
        this.q5008 = q5008;
    }

    public Integer getQ5008a() {
        return q5008a;
    }

    public void setQ5008a(Integer q5008a) {
        this.q5008a = q5008a;
    }

    public Integer getQ5008b() {
        return q5008b;
    }

    public void setQ5008b(Integer q5008b) {
        this.q5008b = q5008b;
    }

    public Integer getQ5008c() {
        return q5008c;
    }

    public void setQ5008c(Integer q5008c) {
        this.q5008c = q5008c;
    }

    public Integer getQ5009() {
        return q5009;
    }

    public void setQ5009(Integer q5009) {
        this.q5009 = q5009;
    }

    public Integer getQ5009a() {
        return q5009a;
    }

    public void setQ5009a(Integer q5009a) {
        this.q5009a = q5009a;
    }

    public Integer getQ5009b() {
        return q5009b;
    }

    public void setQ5009b(Integer q5009b) {
        this.q5009b = q5009b;
    }

    public Integer getQ5009c() {
        return q5009c;
    }

    public void setQ5009c(Integer q5009c) {
        this.q5009c = q5009c;
    }

    public Integer getQ5010() {
        return q5010;
    }

    public void setQ5010(Integer q5010) {
        this.q5010 = q5010;
    }

    public Integer getQ5010a() {
        return q5010a;
    }

    public void setQ5010a(Integer q5010a) {
        this.q5010a = q5010a;
    }

    public Integer getQ5010b() {
        return q5010b;
    }

    public void setQ5010b(Integer q5010b) {
        this.q5010b = q5010b;
    }

    public Integer getQ5010c() {
        return q5010c;
    }

    public void setQ5010c(Integer q5010c) {
        this.q5010c = q5010c;
    }

    public Integer getQ5011() {
        return q5011;
    }

    public void setQ5011(Integer q5011) {
        this.q5011 = q5011;
    }

    public Integer getQ5011a() {
        return q5011a;
    }

    public void setQ5011a(Integer q5011a) {
        this.q5011a = q5011a;
    }

    public Integer getQ5011b() {
        return q5011b;
    }

    public void setQ5011b(Integer q5011b) {
        this.q5011b = q5011b;
    }

    public Integer getQ5011c() {
        return q5011c;
    }

    public void setQ5011c(Integer q5011c) {
        this.q5011c = q5011c;
    }

    public Integer getQ5012() {
        return q5012;
    }

    public void setQ5012(Integer q5012) {
        this.q5012 = q5012;
    }

    public Integer getQ5012a() {
        return q5012a;
    }

    public void setQ5012a(Integer q5012a) {
        this.q5012a = q5012a;
    }

    public Integer getQ5012b() {
        return q5012b;
    }

    public void setQ5012b(Integer q5012b) {
        this.q5012b = q5012b;
    }

    public Integer getQ5012c() {
        return q5012c;
    }

    public void setQ5012c(Integer q5012c) {
        this.q5012c = q5012c;
    }

    public Integer getQ5013() {
        return q5013;
    }

    public void setQ5013(Integer q5013) {
        this.q5013 = q5013;
    }

    public Integer getQ5013a() {
        return q5013a;
    }

    public void setQ5013a(Integer q5013a) {
        this.q5013a = q5013a;
    }

    public Integer getQ5013b() {
        return q5013b;
    }

    public void setQ5013b(Integer q5013b) {
        this.q5013b = q5013b;
    }

    public Integer getQ5013c() {
        return q5013c;
    }

    public void setQ5013c(Integer q5013c) {
        this.q5013c = q5013c;
    }

    public Integer getQ5014() {
        return q5014;
    }

    public void setQ5014(Integer q5014) {
        this.q5014 = q5014;
    }

    public Integer getQ5014a() {
        return q5014a;
    }

    public void setQ5014a(Integer q5014a) {
        this.q5014a = q5014a;
    }

    public Integer getQ5014b() {
        return q5014b;
    }

    public void setQ5014b(Integer q5014b) {
        this.q5014b = q5014b;
    }

    public Integer getQ5014c() {
        return q5014c;
    }

    public void setQ5014c(Integer q5014c) {
        this.q5014c = q5014c;
    }

    public Integer getQ5015() {
        return q5015;
    }

    public void setQ5015(Integer q5015) {
        this.q5015 = q5015;
    }

    public Integer getQ5015a() {
        return q5015a;
    }

    public void setQ5015a(Integer q5015a) {
        this.q5015a = q5015a;
    }

    public Integer getQ5015b() {
        return q5015b;
    }

    public void setQ5015b(Integer q5015b) {
        this.q5015b = q5015b;
    }

    public Integer getQ5015c() {
        return q5015c;
    }

    public void setQ5015c(Integer q5015c) {
        this.q5015c = q5015c;
    }

    public Integer getQ5016() {
        return q5016;
    }

    public void setQ5016(Integer q5016) {
        this.q5016 = q5016;
    }

    public Integer getQ5016a() {
        return q5016a;
    }

    public void setQ5016a(Integer q5016a) {
        this.q5016a = q5016a;
    }

    public Integer getQ5016b() {
        return q5016b;
    }

    public void setQ5016b(Integer q5016b) {
        this.q5016b = q5016b;
    }

    public Integer getQ5016c() {
        return q5016c;
    }

    public void setQ5016c(Integer q5016c) {
        this.q5016c = q5016c;
    }

    public String getQ5017() {
        return q5017;
    }

    public void setQ5017(String q5017) {
        this.q5017 = q5017;
    }

    public Integer getQ5017a() {
        return q5017a;
    }

    public void setQ5017a(Integer q5017a) {
        this.q5017a = q5017a;
    }

    public Integer getQ5017b() {
        return q5017b;
    }

    public void setQ5017b(Integer q5017b) {
        this.q5017b = q5017b;
    }

    public Integer getQ5017c() {
        return q5017c;
    }

    public void setQ5017c(Integer q5017c) {
        this.q5017c = q5017c;
    }

    public Integer getQ5017d() {
        return q5017d;
    }

    public void setQ5017d(Integer q5017d) {
        this.q5017d = q5017d;
    }

    public Integer getQ6000() {
        return q6000;
    }

    public void setQ6000(Integer q6000) {
        this.q6000 = q6000;
    }

    public Integer getQ6002() {
        return q6002;
    }

    public void setQ6002(Integer q6002) {
        this.q6002 = q6002;
    }

    public Integer getQ6100() {
        return q6100;
    }

    public void setQ6100(Integer q6100) {
        this.q6100 = q6100;
    }

    public Integer getQ6101() {
        return q6101;
    }

    public void setQ6101(Integer q6101) {
        this.q6101 = q6101;
    }

    public Integer getQ6102() {
        return q6102;
    }

    public void setQ6102(Integer q6102) {
        this.q6102 = q6102;
    }

    public Integer getQ6103() {
        return q6103;
    }

    public void setQ6103(Integer q6103) {
        this.q6103 = q6103;
    }

    public Integer getQ6103a() {
        return q6103a;
    }

    public void setQ6103a(Integer q6103a) {
        this.q6103a = q6103a;
    }

    public Integer getQ6104() {
        return q6104;
    }

    public void setQ6104(Integer q6104) {
        this.q6104 = q6104;
    }

    public Integer getQ6110() {
        return q6110;
    }

    public void setQ6110(Integer q6110) {
        this.q6110 = q6110;
    }

    public Integer getQ6111() {
        return q6111;
    }

    public void setQ6111(Integer q6111) {
        this.q6111 = q6111;
    }

    public Integer getQ6112() {
        return q6112;
    }

    public void setQ6112(Integer q6112) {
        this.q6112 = q6112;
    }

    public Integer getQ6113() {
        return q6113;
    }

    public void setQ6113(Integer q6113) {
        this.q6113 = q6113;
    }

    public Integer getQ6120() {
        return q6120;
    }

    public void setQ6120(Integer q6120) {
        this.q6120 = q6120;
    }

    public Integer getQ6121() {
        return q6121;
    }

    public void setQ6121(Integer q6121) {
        this.q6121 = q6121;
    }

    public Integer getQ6122() {
        return q6122;
    }

    public void setQ6122(Integer q6122) {
        this.q6122 = q6122;
    }

    public Integer getQ6123() {
        return q6123;
    }

    public void setQ6123(Integer q6123) {
        this.q6123 = q6123;
    }

    public Integer getQ6130() {
        return q6130;
    }

    public void setQ6130(Integer q6130) {
        this.q6130 = q6130;
    }

    public Integer getQ6131() {
        return q6131;
    }

    public void setQ6131(Integer q6131) {
        this.q6131 = q6131;
    }

    public Integer getQ6132() {
        return q6132;
    }

    public void setQ6132(Integer q6132) {
        this.q6132 = q6132;
    }

    public Integer getQ6133() {
        return q6133;
    }

    public void setQ6133(Integer q6133) {
        this.q6133 = q6133;
    }

    public Integer getQ6140() {
        return q6140;
    }

    public void setQ6140(Integer q6140) {
        this.q6140 = q6140;
    }

    public Integer getQ6141() {
        return q6141;
    }

    public void setQ6141(Integer q6141) {
        this.q6141 = q6141;
    }

    public Integer getQ6142() {
        return q6142;
    }

    public void setQ6142(Integer q6142) {
        this.q6142 = q6142;
    }

    public Integer getQ6150() {
        return q6150;
    }

    public void setQ6150(Integer q6150) {
        this.q6150 = q6150;
    }

    public Integer getQ6151() {
        return q6151;
    }

    public void setQ6151(Integer q6151) {
        this.q6151 = q6151;
    }

    public Integer getQ6152() {
        return q6152;
    }

    public void setQ6152(Integer q6152) {
        this.q6152 = q6152;
    }

    public Integer getQ6160() {
        return q6160;
    }

    public void setQ6160(Integer q6160) {
        this.q6160 = q6160;
    }

    public Integer getQ6161() {
        return q6161;
    }

    public void setQ6161(Integer q6161) {
        this.q6161 = q6161;
    }

    public Integer getQ6162() {
        return q6162;
    }

    public void setQ6162(Integer q6162) {
        this.q6162 = q6162;
    }

    public Integer getQ6200() {
        return q6200;
    }

    public void setQ6200(Integer q6200) {
        this.q6200 = q6200;
    }

    public Integer getQ6201() {
        return q6201;
    }

    public void setQ6201(Integer q6201) {
        this.q6201 = q6201;
    }

    public Integer getQ6202() {
        return q6202;
    }

    public void setQ6202(Integer q6202) {
        this.q6202 = q6202;
    }

    public Integer getQ6203() {
        return q6203;
    }

    public void setQ6203(Integer q6203) {
        this.q6203 = q6203;
    }

    public Integer getQ6204() {
        return q6204;
    }

    public void setQ6204(Integer q6204) {
        this.q6204 = q6204;
    }

    public Integer getQ6204a() {
        return q6204a;
    }

    public void setQ6204a(Integer q6204a) {
        this.q6204a = q6204a;
    }

    public Integer getQ6205() {
        return q6205;
    }

    public void setQ6205(Integer q6205) {
        this.q6205 = q6205;
    }

    public Integer getQ6210() {
        return q6210;
    }

    public void setQ6210(Integer q6210) {
        this.q6210 = q6210;
    }

    public Integer getQ6211() {
        return q6211;
    }

    public void setQ6211(Integer q6211) {
        this.q6211 = q6211;
    }

    public Integer getQ6212() {
        return q6212;
    }

    public void setQ6212(Integer q6212) {
        this.q6212 = q6212;
    }

    public Integer getQ6220() {
        return q6220;
    }

    public void setQ6220(Integer q6220) {
        this.q6220 = q6220;
    }

    public Integer getQ6221() {
        return q6221;
    }

    public void setQ6221(Integer q6221) {
        this.q6221 = q6221;
    }

    public Integer getQ6222() {
        return q6222;
    }

    public void setQ6222(Integer q6222) {
        this.q6222 = q6222;
    }

    public Integer getQ6223() {
        return q6223;
    }

    public void setQ6223(Integer q6223) {
        this.q6223 = q6223;
    }

    public Integer getQ6230() {
        return q6230;
    }

    public void setQ6230(Integer q6230) {
        this.q6230 = q6230;
    }

    public Integer getQ6231() {
        return q6231;
    }

    public void setQ6231(Integer q6231) {
        this.q6231 = q6231;
    }

    public Integer getQ6232() {
        return q6232;
    }

    public void setQ6232(Integer q6232) {
        this.q6232 = q6232;
    }

    public Integer getQ6233() {
        return q6233;
    }

    public void setQ6233(Integer q6233) {
        this.q6233 = q6233;
    }

    public Integer getQ6240() {
        return q6240;
    }

    public void setQ6240(Integer q6240) {
        this.q6240 = q6240;
    }

    public Integer getQ6241() {
        return q6241;
    }

    public void setQ6241(Integer q6241) {
        this.q6241 = q6241;
    }

    public Integer getQ6242() {
        return q6242;
    }

    public void setQ6242(Integer q6242) {
        this.q6242 = q6242;
    }

    public Integer getQ6250() {
        return q6250;
    }

    public void setQ6250(Integer q6250) {
        this.q6250 = q6250;
    }

    public Integer getQ6251() {
        return q6251;
    }

    public void setQ6251(Integer q6251) {
        this.q6251 = q6251;
    }

    public Integer getQ6252() {
        return q6252;
    }

    public void setQ6252(Integer q6252) {
        this.q6252 = q6252;
    }

    public Integer getQ6300() {
        return q6300;
    }

    public void setQ6300(Integer q6300) {
        this.q6300 = q6300;
    }

    public Integer getQ6301() {
        return q6301;
    }

    public void setQ6301(Integer q6301) {
        this.q6301 = q6301;
    }

    public Integer getQ6302() {
        return q6302;
    }

    public void setQ6302(Integer q6302) {
        this.q6302 = q6302;
    }

    public Integer getQ6303() {
        return q6303;
    }

    public void setQ6303(Integer q6303) {
        this.q6303 = q6303;
    }

    public Integer getQ6304() {
        return q6304;
    }

    public void setQ6304(Integer q6304) {
        this.q6304 = q6304;
    }

    public Integer getQ6305() {
        return q6305;
    }

    public void setQ6305(Integer q6305) {
        this.q6305 = q6305;
    }

    public Integer getQ6306() {
        return q6306;
    }

    public void setQ6306(Integer q6306) {
        this.q6306 = q6306;
    }

    public Integer getQ6307() {
        return q6307;
    }

    public void setQ6307(Integer q6307) {
        this.q6307 = q6307;
    }

    public Integer getQ6308() {
        return q6308;
    }

    public void setQ6308(Integer q6308) {
        this.q6308 = q6308;
    }

    public Integer getQ6309() {
        return q6309;
    }

    public void setQ6309(Integer q6309) {
        this.q6309 = q6309;
    }

    public Integer getQ6310() {
        return q6310;
    }

    public void setQ6310(Integer q6310) {
        this.q6310 = q6310;
    }

    public Integer getQ6311() {
        return q6311;
    }

    public void setQ6311(Integer q6311) {
        this.q6311 = q6311;
    }

    public Integer getQ6312() {
        return q6312;
    }

    public void setQ6312(Integer q6312) {
        this.q6312 = q6312;
    }

    public Integer getQ6313() {
        return q6313;
    }

    public void setQ6313(Integer q6313) {
        this.q6313 = q6313;
    }

    public Integer getQ6400a() {
        return q6400a;
    }

    public void setQ6400a(Integer q6400a) {
        this.q6400a = q6400a;
    }

    public Integer getQ6400b() {
        return q6400b;
    }

    public void setQ6400b(Integer q6400b) {
        this.q6400b = q6400b;
    }

    public Integer getQ6400c() {
        return q6400c;
    }

    public void setQ6400c(Integer q6400c) {
        this.q6400c = q6400c;
    }

    public Integer getQ6400d() {
        return q6400d;
    }

    public void setQ6400d(Integer q6400d) {
        this.q6400d = q6400d;
    }

    public Integer getQ6400e() {
        return q6400e;
    }

    public void setQ6400e(Integer q6400e) {
        this.q6400e = q6400e;
    }

    public Integer getQ6400f() {
        return q6400f;
    }

    public void setQ6400f(Integer q6400f) {
        this.q6400f = q6400f;
    }

    public Integer getQ6400g() {
        return q6400g;
    }

    public void setQ6400g(Integer q6400g) {
        this.q6400g = q6400g;
    }

    public Integer getQ6400h() {
        return q6400h;
    }

    public void setQ6400h(Integer q6400h) {
        this.q6400h = q6400h;
    }

    public Integer getQ6400i() {
        return q6400i;
    }

    public void setQ6400i(Integer q6400i) {
        this.q6400i = q6400i;
    }

    public String getQ6400j() {
        return q6400j;
    }

    public void setQ6400j(String q6400j) {
        this.q6400j = q6400j;
    }

    public Integer getQ6401() {
        return q6401;
    }

    public void setQ6401(Integer q6401) {
        this.q6401 = q6401;
    }

    public Integer getQ6600() {
        return q6600;
    }

    public void setQ6600(Integer q6600) {
        this.q6600 = q6600;
    }

    public Integer getQ6001a() {
        return q6001a;
    }

    public void setQ6001a(Integer q6001a) {
        this.q6001a = q6001a;
    }

    public Integer getQ6001b() {
        return q6001b;
    }

    public void setQ6001b(Integer q6001b) {
        this.q6001b = q6001b;
    }

    public Integer getQ6260() {
        return q6260;
    }

    public void setQ6260(Integer q6260) {
        this.q6260 = q6260;
    }

    public Integer getQ6601a() {
        return q6601a;
    }

    public void setQ6601a(Integer q6601a) {
        this.q6601a = q6601a;
    }

    public Integer getQ6601b() {
        return q6601b;
    }

    public void setQ6601b(Integer q6601b) {
        this.q6601b = q6601b;
    }

    public Integer getQ6601c() {
        return q6601c;
    }

    public void setQ6601c(Integer q6601c) {
        this.q6601c = q6601c;
    }

    public Integer getQ6501() {
        return q6501;
    }

    public void setQ6501(Integer q6501) {
        this.q6501 = q6501;
    }

    public Integer getQ6502() {
        return q6502;
    }

    public void setQ6502(Integer q6502) {
        this.q6502 = q6502;
    }

    public Integer getQ6503() {
        return q6503;
    }

    public void setQ6503(Integer q6503) {
        this.q6503 = q6503;
    }

    public Integer getQ6504() {
        return q6504;
    }

    public void setQ6504(Integer q6504) {
        this.q6504 = q6504;
    }

    public Integer getQ6505() {
        return q6505;
    }

    public void setQ6505(Integer q6505) {
        this.q6505 = q6505;
    }

    public Integer getQ6506() {
        return q6506;
    }

    public void setQ6506(Integer q6506) {
        this.q6506 = q6506;
    }

    public Integer getQ6507() {
        return q6507;
    }

    public void setQ6507(Integer q6507) {
        this.q6507 = q6507;
    }

    public Integer getQ6508() {
        return q6508;
    }

    public void setQ6508(Integer q6508) {
        this.q6508 = q6508;
    }

    public Integer getQ6509() {
        return q6509;
    }

    public void setQ6509(Integer q6509) {
        this.q6509 = q6509;
    }

    public Integer getQ6510() {
        return q6510;
    }

    public void setQ6510(Integer q6510) {
        this.q6510 = q6510;
    }

    public Integer getQ6604() {
        return q6604;
    }

    public void setQ6604(Integer q6604) {
        this.q6604 = q6604;
    }

    public Integer getQ6605() {
        return q6605;
    }

    public void setQ6605(Integer q6605) {
        this.q6605 = q6605;
    }

    public Integer getQ6606() {
        return q6606;
    }

    public void setQ6606(Integer q6606) {
        this.q6606 = q6606;
    }

    public Integer getQ6607() {
        return q6607;
    }

    public void setQ6607(Integer q6607) {
        this.q6607 = q6607;
    }

    public Integer getQ6608() {
        return q6608;
    }

    public void setQ6608(Integer q6608) {
        this.q6608 = q6608;
    }

    public Integer getQ6609() {
        return q6609;
    }

    public void setQ6609(Integer q6609) {
        this.q6609 = q6609;
    }

    public Integer getQ6610() {
        return q6610;
    }

    public void setQ6610(Integer q6610) {
        this.q6610 = q6610;
    }

    public Integer getQ6611() {
        return q6611;
    }

    public void setQ6611(Integer q6611) {
        this.q6611 = q6611;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public String getUserLong() {
        return userLong;
    }

    public void setUserLong(String userLong) {
        this.userLong = userLong;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public List<Q0993> getQ0993() {
        return q0993;
    }

    public void setQ0993(List<Q0993> q0993) {
        this.q0993 = q0993;
    }

}