package selleck.email.dao;

import java.util.List;

import common.handle.model.Criteria;
import selleck.email.interest.beans.DictClass;

public interface DictMapper {
	
	List<DictClass> selectByExample(Criteria criteria);
	void insertDict(DictClass dc);
}