package gof;

/**
 * @ClassName Builder
 * @Description 建造者模式
 * @Author Administrator
 * @Date 2019/12/21 15:57
 * @Version 1.0
 */
public class Builder {
    private Integer code;
    private String message;
    private Object data;

    public Builder() {

    }

    public Builder(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Builder code(Integer code){
        this.code = code;
        return this;
    }
    public Builder message(String message){
        this.message = message;
        return this;
    }
    public Builder data(Object data){
        this.data = data;
        return this;
    }
    public Builder build(){
        return new Builder(this.code, this.message, this.data);
    }
}
