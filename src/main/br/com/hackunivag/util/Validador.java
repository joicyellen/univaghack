package br.com.hackunivag.util;

import java.util.Collection;
import java.util.Date;

public class Validador {

	public static boolean isStringValida(String arg) {
		if ((arg != null) && (!arg.trim().equals(""))) {
			return true;
		}
		return false;
	}

	public static boolean isNumericoValido(Long arg) {
		if (arg != null) {
			try {
				new Long(arg);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isNumericoValido(String arg) {
		if (arg != null) {
			try {
				new Long(arg);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isNumericoValido(Double arg) {
		if (arg != null) {
			try {
				new Double(arg);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isObjetoValido(Object arg) {
		if (arg != null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isCollectionValida(Collection colecao) {
		if (colecao != null && !colecao.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isArrayValida(String[] array) {
		if (array != null && array.length > 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isDataValida(Date arg) {
		if (arg != null) {
			return true;
		}
		return false;
	}

	public static boolean isNumericoValido(Integer arg) {
		if (arg != null) {
			try {
				new Integer(arg);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isEnumValido(BaseEnum arg) {
		if (arg != null) {
			Integer value = (Integer) arg.getValor();
			return isNumericoValido(value);
		} else {
			return false;
		}
	}
}
