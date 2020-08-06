package beans;

/**
 * 订单详情的实体
 * @author azzhu
 * @create 2020-07-24 00:03:17
 */
public class OrderItem {
    private String itemid; //id
    private int quantity; //数量
    private double subtotal; //小计

    private Product product;    // 订单项中的商品信息
    private Order order;        // 订单项属于哪个订单

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
