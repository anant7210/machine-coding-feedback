package com.ioParser.interfaces;

import java.util.List;

import com.strategies.interfaces.ISplitInput;

public interface IInputReader {
	ISplitInput parseInput(List<String> input);
}
