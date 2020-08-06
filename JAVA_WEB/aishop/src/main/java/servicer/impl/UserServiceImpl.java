package servicer.impl;

import beans.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import servicer.UserService;
import utils.MailUtils;

import java.sql.SQLException;

/**
 * @author azzhu
 * @create 2020-08-06 08:54:31
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void regist(User user) throws SQLException {
        // 保存用户
        userDao.save(user);

        //发送邮件
        MailUtils.sendMail2(user.getEmail(),user.getCode());
    }

    @Override
    public boolean activeUser(String code) throws SQLException {
        //1.找人
        User user=userDao.findByCode(code);
        if(null!=user){
            //可以根据激活码查询到一个用户
            //修改用户的状态,清除激活码
            user.setState(1);
            user.setCode(null);
            //对数据库执行一次真实的更新操作  update user set state=1 , code=null where uid=?
            //update user set username=? , password=? ,name =? ,email=?, telephone =? ,birthday =? ,sex=? ,state=? ,code= ? where uid=?
            userDao.updateUser(user);
            return  true;
        }else{
            //不可以根据激活码查询到一个用户
            throw new RuntimeException("用户激活码无效，请重试或重新发送激活邮件");
        }
    }

    @Override
    public User login(User user) throws SQLException {
        return userDao.find(user);
    }
}
