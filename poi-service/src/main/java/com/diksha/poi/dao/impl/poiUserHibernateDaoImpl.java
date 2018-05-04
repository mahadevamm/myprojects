package com.diksha.poi.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.diksha.poi.bo.model.EmployeeeBO;
import com.diksha.poi.bo.model.NameBO;
import com.diksha.poi.dao.BaseHibernateDao;
import com.diksha.poi.dao.POIDao;
import com.diksha.poi.domain.model.EmployeeeDO;
import com.diksha.poi.domain.model.User;
import com.diksha.poi.common.Common;
import com.diksha.poi.domain.model.NameDO;
import com.diksha.poi.transformer.model.UserDtoConverter;

@Repository("poiDao")
public class poiUserHibernateDaoImpl implements POIDao {
	private static final Log LOGGER = LogFactory.getLog(poiUserHibernateDaoImpl.class);

	@Resource(name = "poiHibernateDao")
	private BaseHibernateDao<User, Integer> poiHibernateDao;

	private final String HQL_LOAD_ALL_USER = "from User";
	private final String HQL_LOAD_BY_USER ="from User where id = :id";
    private final String HQL_LOAD_ALL_USER1="from EmployeeeDO ";
	public List<User> getAllUsers() {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = poiHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_USER);
		List<User> users = query.list();
		return users;
	}

	public void setDhcHibernateDao(BaseHibernateDao<User, Integer> poiHibernateDao) {
		this.poiHibernateDao = poiHibernateDao;
	}

	public User getUser(int id) {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("In get User");
		}
		Session session = poiHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_BY_USER);
		query.setParameter("id", id);
		List<User> user = query.list();
		return user.get(0);
	}

	public User createUser(User user) {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = poiHibernateDao.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(user);
		return user;
	}

	public User updateUser(User user) {
		// TODO Auto-generated method stub
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("In update");
		}
		Session session=poiHibernateDao.getSessionFactory().getCurrentSession();
		session.update(user);
		return user;
	}

	@Override
	public Response createmple(EmployeeeDO convertBOTODOCreatemple) {
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("in SelectProject");
		}
		Session session=poiHibernateDao.getSessionFactory().getCurrentSession();
		session.save(convertBOTODOCreatemple);
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("message","employeee inserted succesfully");
		return Response.ok(map).build();
	}

	@Override
	public List<EmployeeeDO> getcreatemple12() {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = poiHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_USER1);
		List<EmployeeeDO> users = query.list();
		return users;
	}

	@Override
	public Response addName(NameBO name) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In update");
		}

		NameDO nameDO = UserDtoConverter
				.convertBOTODOname(name);
		Session session = poiHibernateDao.getSessionFactory()
				.getCurrentSession();
		session.saveOrUpdate(nameDO);

		//QuestionBO bo = UserDtoConverter.convertDOsTOBOQuestion(questionDO);

		//for (OptionsBO bo1 : question.getOptionsBOs()) {
		//	bo1.setQuestionid(bo.getId());
		//	insertOptions(bo1);
		//}

		HashMap map = new HashMap();
		map.put("message", "inserted sfly");

		return Response.ok(map).build();
	
	}
	

} 
