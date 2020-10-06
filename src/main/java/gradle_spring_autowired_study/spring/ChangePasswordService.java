package gradle_spring_autowired_study.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
    @Autowired
    private MemberDao memberDao;

    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPwd, newPwd);
        memberDao.update(member);
    }

	public void setMemberDao(MemberDao memberDao2) {
		
	}

}
