package com.elangzhi.rate.controller.tip;

public class ErrorTip implements Tip {
    private Boolean success;
    private Integer code;
    private Object data;
    
    public ErrorTip(){
    	
    }
    
    public ErrorTip(Integer code){
    	this.success = false;
    	this.code = code;
    }
    
	public Boolean isSuccess() {
		return this.success;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return this.data;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return this.code;
	}
    
}
