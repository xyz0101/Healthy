package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.CommentReplyDAO;
import com.Healthy.model.CommentReply;
import com.Healthy.model.StadiumComment;
import com.util.Utils;
@Repository
public class CommentReplyDAOImpl extends HibernateDaoSupport implements CommentReplyDAO {
	private static final String FIND_BY_USERID="from CommentReply u where u.replyUser = ?";
	 private static final String FIND_BY_DAYDIFF="select * from comment_reply where TIMESTAMPDIFF(DAY,reply_time,CURRENT_TIMESTAMP())<= ?";
	 private static final String FIND_BY_MONTHDIFF="select * from comment_reply where TIMESTAMPDIFF(MONTH,reply_time,CURRENT_TIMESTAMP())<= ?";
	
	private static final String FIND_BY_ID="from CommentReply s where s.replyId like ?";
	
	
	public static final String FIND_BY_COMMENTID="from CommentReply c  where c.stadiumComment like ? order by c.replyTime desc";
	@Autowired
	public void MySessionfactory(SessionFactory sessionfactory){
		super.setSessionFactory(sessionfactory);
	}
	@Override
	public List<CommentReply> findReply(StadiumComment stadiumcomment) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		
		return (List<CommentReply>) tmp.find(FIND_BY_COMMENTID,  stadiumcomment);
	}
	@Override
	public void add(CommentReply commentreply) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(commentreply);
		tmp.flush();
		
		
	}
	@Override
	public void delete(CommentReply commentreply) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.delete(commentreply);
		tmp.flush();
		
	}
	@Override
	public List<CommentReply> findAll() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from CommentReply c order by c.replyTime desc").list();
	}
	@Override
	public List<CommentReply> findByUserId(String userid) {
		return Utils.findInHQL(this,FIND_BY_USERID , new String[]{userid});
	}
	@Override
	public List<CommentReply> findByDiffDay(String diffday) {
		CommentReply co = new CommentReply();
		return Utils.findInSQL(co, this, FIND_BY_DAYDIFF, new String[]{diffday});
	}
	@Override
	public List<CommentReply> findByDiffMonth(String diffmonth) {
		CommentReply co = new CommentReply();
		return Utils.findInSQL(co, this, FIND_BY_MONTHDIFF, new String[]{diffmonth});
	}
	@Override
	public List<CommentReply> findById(String replyid) {
		return Utils.findInHQL(this, FIND_BY_ID,new String[]{replyid});
	}
	

}
