package liangliang.bigdata.service;

import java.util.List;

/**
 * 通用多结果Service返回结构
 * Created by 瓦力.
 */
public class ServiceMultiResult<T> {
    private long total;//数据库总共有多少数据
    private List<T> result;

    public ServiceMultiResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
//获取当前结果集
    public int getResultSize() {
        if (this.result == null) {
            return 0;
        }
        return this.result.size();
    }
}
