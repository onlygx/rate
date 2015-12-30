package com.elangzhi.rate.controller.tip;

public class SuccessTip implements Tip {

    private Boolean success;
    private Object data;
    
    public SuccessTip(){
    	this.success = true;
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


}
