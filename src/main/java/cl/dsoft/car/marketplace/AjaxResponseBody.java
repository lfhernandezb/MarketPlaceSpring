/**
 * 
 */
package cl.dsoft.car.marketplace;

import java.util.List;
import java.util.Set;

import cl.dsoft.car.marketplace.domain.Comuna;

/**
 * @author lfhernandez
 *
 */
public class AjaxResponseBody {

	String msg;
	
	String code;
	
	List<Comuna> comunas;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Comuna> getComunas() {
		return comunas;
	}

	public void setComunas(List<Comuna> comunas) {
		this.comunas = comunas;
	}

}
