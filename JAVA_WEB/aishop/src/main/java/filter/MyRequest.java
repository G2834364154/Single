package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 之前的MyRequest增强了request.getParameter("name");方法
 * 增强了所有的获取参数的方法request.getParameterValues("name");
 * 增强了所有的获取参数的方法request.getParameterMap();
 * @author azzhu
 * @create 2020-07-21 17:26:36
 */
public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    //是否已经被编码，默认为true，没有没有编码
    private boolean flag= true;

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    /**
     * 获取指定名称的第一个参数
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        if(name==null || name.trim().length()==0){
            return null;
        }
        String[] values = getParameterValues(name);
        if(values==null || values.length==0){
            return null;
        }

        return values[0];
    }

    /**
     * 获取指定名称的所有参数
     * @param name
     * @return
     */
    @Override
    public String[] getParameterValues(String name) {
        if(name==null || name.trim().length()==0){
            return null;
        }
        Map<String, String[]> map = getParameterMap();
        if(map==null || map.size()==0){
            return null;
        }

        return map.get(name);
    }

    /**
     * 获得所有的内容，key：指定的名称；value：指定名称对象的所有值
     * @return
     */
    @Override
    public Map<String, String[]> getParameterMap() {
        /**
         * 首先判断请求方式
         * 若为post  request.setchar...(utf-8)
         * 若为get 将map中的值遍历编码就可以了
         */
        String method = request.getMethod();
        if("post".equalsIgnoreCase(method)) {
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if("get".equalsIgnoreCase(method)) {
            Map<String, String[]> map = request.getParameterMap();
            if(flag) {
                for (String key : map.keySet()) {
                    String[] allValues = map.get(key);
                    // 继续遍历数组
                    for (int i = 0; i < allValues.length; i++) {
                        // 编码
                        try {
                            allValues[i] = new String(allValues[i].getBytes("iso-8859-1"),"utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                flag=false;
            }
            //需要遍历map 修改value的每一个数据的编码
            return map;
        }
        return super.getParameterMap();
    }
}
