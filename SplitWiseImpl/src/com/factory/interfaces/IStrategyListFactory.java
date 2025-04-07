package com.factory.interfaces;

import java.util.List;

import com.interfaces.IStrategyList;

public interface IStrategyListFactory {
	IStrategyList getStrategyList(List<String> strategiesPresent);
}
