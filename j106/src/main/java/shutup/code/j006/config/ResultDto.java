package shutup.code.j006.config;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

/**
 *  Token 으로 데이터 주고 받는 형식 정의 
 *
 */
@Getter
@ToString
public class ResultDto{
	
	private boolean result;
	private String msg;
	private Object object;
	
	public ResultDto(boolean result, String msg, Object object) {
		this.result = result;
		this.msg = msg;
		this.object = object;
	}

}
