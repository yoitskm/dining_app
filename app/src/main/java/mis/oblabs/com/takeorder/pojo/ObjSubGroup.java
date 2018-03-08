package mis.oblabs.com.takeorder.pojo;

/**
 * Created by ato on 07/03/18.
 */

public class ObjSubGroup {

    private String SubGrpImage;

    private String Activate;

    private String SubGrpDiscPer;

    private String SubGrpShortName;

    private String SubGroupSpaSaloonFlag;

    private String GroupID;

    private String SubGroupID;

    private String SubGroupName;

    public String getSubGrpImage ()
    {
        return SubGrpImage;
    }

    public void setSubGrpImage (String SubGrpImage)
    {
        this.SubGrpImage = SubGrpImage;
    }

    public String getActivate ()
    {
        return Activate;
    }

    public void setActivate (String Activate)
    {
        this.Activate = Activate;
    }

    public String getSubGrpDiscPer ()
    {
        return SubGrpDiscPer;
    }

    public void setSubGrpDiscPer (String SubGrpDiscPer)
    {
        this.SubGrpDiscPer = SubGrpDiscPer;
    }

    public String getSubGrpShortName ()
    {
        return SubGrpShortName;
    }

    public void setSubGrpShortName (String SubGrpShortName)
    {
        this.SubGrpShortName = SubGrpShortName;
    }

    public String getSubGroupSpaSaloonFlag ()
    {
        return SubGroupSpaSaloonFlag;
    }

    public void setSubGroupSpaSaloonFlag (String SubGroupSpaSaloonFlag)
    {
        this.SubGroupSpaSaloonFlag = SubGroupSpaSaloonFlag;
    }

    public String getGroupID ()
    {
        return GroupID;
    }

    public void setGroupID (String GroupID)
    {
        this.GroupID = GroupID;
    }

    public String getSubGroupID ()
    {
        return SubGroupID;
    }

    public void setSubGroupID (String SubGroupID)
    {
        this.SubGroupID = SubGroupID;
    }

    public String getSubGroupName ()
    {
        return SubGroupName;
    }

    public void setSubGroupName (String SubGroupName)
    {
        this.SubGroupName = SubGroupName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SubGrpImage = "+SubGrpImage+", Activate = "+Activate+", SubGrpDiscPer = "+SubGrpDiscPer+", SubGrpShortName = "+SubGrpShortName+", SubGroupSpaSaloonFlag = "+SubGroupSpaSaloonFlag+", GroupID = "+GroupID+", SubGroupID = "+SubGroupID+", SubGroupName = "+SubGroupName+"]";
    }
}
