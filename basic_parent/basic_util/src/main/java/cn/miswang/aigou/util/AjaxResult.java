package cn.miswang.aigou.util;

public class AjaxResult {
    private Boolean success=true;
    private String mssage="操作成功";
    private Object resultObj;

    public Object getResultObj() {
        return resultObj;
    }

    public AjaxResult setResultObj(Object resultObj) {
        this.resultObj = resultObj;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public AjaxResult setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getMssage() {
        return mssage;
    }

    public AjaxResult setMssage(String mssage) {
        this.mssage = mssage;
        return this;
    }
    //AjaxResult.ajaxResult()成功
    //AjaxResult.ajaxResult().setMessage()成功
    //AjaxResult.ajaxResult().setSuccess(false),setMessage("失败");
    public static AjaxResult ajaxResult(){
        return new AjaxResult();
    }
}
