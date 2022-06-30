package skills;

public class SkillModel {
    int skillId;
    String skillName;

    public SkillModel(int skillId, String skillName) {
	super();
	this.skillId = skillId;
	this.skillName = skillName;
    }

    public int getSkillId() {
	return skillId;
    }

    public void setSkillId(int skillId) {
	this.skillId = skillId;
    }

    public String getSkillName() {
	return skillName;
    }

    public void setSkillName(String skillName) {
	this.skillName = skillName;
    }

}
