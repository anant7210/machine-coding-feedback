package com.ioParser.interfaces;

import java.util.List;

import com.strategies.splitObjects.SplitResult;

public interface IResultFormatter {
	List<String> getFormattedResult(SplitResult splitResult);
}
