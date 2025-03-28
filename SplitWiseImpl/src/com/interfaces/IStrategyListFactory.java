package com.interfaces;

import java.util.List;

public interface IStrategyListFactory {
	IStrategyList getStrategyList(List<String> strategiesPresent);
}
