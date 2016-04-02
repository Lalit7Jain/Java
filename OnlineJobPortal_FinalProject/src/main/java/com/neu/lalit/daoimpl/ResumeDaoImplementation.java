package com.neu.lalit.daoimpl;

import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.ResumeDao;
import com.neu.lalit.pojo.Resume;

@Repository
public class ResumeDaoImplementation extends GenericDaoImplementation<Resume, Long> implements ResumeDao{

}
