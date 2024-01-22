package com.web.store.exception;

public class ProductNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer bookId; 
	public ProductNotFoundException() { }
	public ProductNotFoundException(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public ProductNotFoundException(String message) {
		super(message);
	}
	public ProductNotFoundException(Throwable cause) {
		super(cause);
	}
	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
