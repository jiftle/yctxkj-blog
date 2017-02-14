package com.yctxkj.blog.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseAdmin<M extends BaseAdmin<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Long id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public M setCreateDate(java.util.Date createDate) {
		set("create_date", createDate);
		return (M)this;
	}

	public java.util.Date getCreateDate() {
		return get("create_date");
	}

	public M setModifyDate(java.util.Date modifyDate) {
		set("modify_date", modifyDate);
		return (M)this;
	}

	public java.util.Date getModifyDate() {
		return get("modify_date");
	}

	public M setDepartment(java.lang.String department) {
		set("department", department);
		return (M)this;
	}

	public java.lang.String getDepartment() {
		return get("department");
	}

	public M setEmail(java.lang.String email) {
		set("email", email);
		return (M)this;
	}

	public java.lang.String getEmail() {
		return get("email");
	}

	public M setIsEnabled(java.lang.Boolean isEnabled) {
		set("is_enabled", isEnabled);
		return (M)this;
	}

	public java.lang.Boolean getIsEnabled() {
		return get("is_enabled");
	}

	public M setIsLocked(java.lang.Boolean isLocked) {
		set("is_locked", isLocked);
		return (M)this;
	}

	public java.lang.Boolean getIsLocked() {
		return get("is_locked");
	}

	public M setLockedDate(java.util.Date lockedDate) {
		set("locked_date", lockedDate);
		return (M)this;
	}

	public java.util.Date getLockedDate() {
		return get("locked_date");
	}

	public M setLoginDate(java.util.Date loginDate) {
		set("login_date", loginDate);
		return (M)this;
	}

	public java.util.Date getLoginDate() {
		return get("login_date");
	}

	public M setLoginFailureCount(java.lang.Integer loginFailureCount) {
		set("login_failure_count", loginFailureCount);
		return (M)this;
	}

	public java.lang.Integer getLoginFailureCount() {
		return get("login_failure_count");
	}

	public M setLoginIp(java.lang.String loginIp) {
		set("login_ip", loginIp);
		return (M)this;
	}

	public java.lang.String getLoginIp() {
		return get("login_ip");
	}

	public M setName(java.lang.String name) {
		set("name", name);
		return (M)this;
	}

	public java.lang.String getName() {
		return get("name");
	}

	public M setPassword(java.lang.String password) {
		set("password", password);
		return (M)this;
	}

	public java.lang.String getPassword() {
		return get("password");
	}

	public M setUsername(java.lang.String username) {
		set("username", username);
		return (M)this;
	}

	public java.lang.String getUsername() {
		return get("username");
	}

}