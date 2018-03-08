package mis.oblabs.com.takeorder.pojo;

/**
 * Created by ato on 07/03/18.
 */

public class ObjGroup {


    String GroupID , GroupName , GrpShortName , GroupSpaSaloonFlag , PrinterName , GrpDiscPer , GroupType;

    public ObjGroup(String groupID, String groupName, String grpShortName, String groupSpaSaloonFlag, String printerName, String grpDiscPer, String groupType) {
        GroupID = groupID;
        GroupName = groupName;
        GrpShortName = grpShortName;
        GroupSpaSaloonFlag = groupSpaSaloonFlag;
        PrinterName = printerName;
        GrpDiscPer = grpDiscPer;
        GroupType = groupType;
    }

    public String getGroupID() {
        return GroupID;
    }

    public void setGroupID(String groupID) {
        GroupID = groupID;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getGrpShortName() {
        return GrpShortName;
    }

    public void setGrpShortName(String grpShortName) {
        GrpShortName = grpShortName;
    }

    public String getGroupSpaSaloonFlag() {
        return GroupSpaSaloonFlag;
    }

    public void setGroupSpaSaloonFlag(String groupSpaSaloonFlag) {
        GroupSpaSaloonFlag = groupSpaSaloonFlag;
    }

    public String getPrinterName() {
        return PrinterName;
    }

    public void setPrinterName(String printerName) {
        PrinterName = printerName;
    }

    public String getGrpDiscPer() {
        return GrpDiscPer;
    }

    public void setGrpDiscPer(String grpDiscPer) {
        GrpDiscPer = grpDiscPer;
    }

    public String getGroupType() {
        return GroupType;
    }

    public void setGroupType(String groupType) {
        GroupType = groupType;
    }
}
