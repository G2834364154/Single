package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单的实体
 *  实体中定义的属性 尽量使用包装类的类型
 *      基本数据类型默认值是0；包装类默认值是null
 * @author azzhu
 * @create 2020-07-24 00:03:40
 */
public class Order {
    private String oid; //订单编号
    private Date ordertime; //下单时间
    private double total; //总计
    private int state; //状态 1=未付款；2=已付款，未发货；3=已发货，未收货；4=收货，订单结束
    private String address; //收货人地址
    private String name; //收货人姓名
    private String telephone; //收货人电话

    // private String uid;
    // 1_程序对象和对象发生关系,而不是对象和对象的属性发生关系
    // 2_设计Order目的:让order携带订单上的数据向service,dao传递,user对象是可以携带更多的数据
    private User user;

    // 程序中体现订单对象和订单项之间关系,我们再项目中的部分功能中有类似的需求:查询订单的同时还需要获取订单下所有的订单项
    private List<OrderItem> list = new ArrayList<>();

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }
}
