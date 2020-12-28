package com.hdu.mxd.service;



import com.hdu.mxd.vo.CourseVO;
import com.hdu.mxd.vo.DataVO;
import com.hdu.mxd.vo.SclassVO;
import com.hdu.mxd.vo.UserVO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface UserService_jhs {
    public DataVO<UserVO> findData(Integer page, Integer limit);
    public DataVO<SclassVO> findDataclass(Integer page, Integer limit);
    public DataVO<CourseVO> findDatacourse(Integer page, Integer limit);
}
