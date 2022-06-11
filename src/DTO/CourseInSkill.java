package DTO;

public class CourseInSkill {
	int courseInSkillId;
	int skillId;
	int courseId;
	public CourseInSkill(int courseInSkillId, int skillId, int courseId) {
		super();
		this.courseInSkillId = courseInSkillId;
		this.skillId = skillId;
		this.courseId = courseId;
	}
	public int getCourseInSkillId() {
		return courseInSkillId;
	}
	public void setCourseInSkillId(int courseInSkillId) {
		this.courseInSkillId = courseInSkillId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	
}
