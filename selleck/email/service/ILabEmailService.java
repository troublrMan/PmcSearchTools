package selleck.email.service;

import java.util.List;

import common.handle.model.Criteria;
import selleck.email.pojo.LabEmail;

public interface ILabEmailService {
	List<LabEmail> selectByExample(Criteria criteria);
	void saveLabEmail(LabEmail labEmail);
	void updateLabEmail(LabEmail labEmail);
	void deleteByCriteria(Criteria criteria);
}
