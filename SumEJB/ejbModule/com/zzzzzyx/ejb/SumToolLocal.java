package com.zzzzzyx.ejb;

import javax.ejb.Local;

@Local
public interface SumToolLocal {
	public float add(float f1, float f2);
}
