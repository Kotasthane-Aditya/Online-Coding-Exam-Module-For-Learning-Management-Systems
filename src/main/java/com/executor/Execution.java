package com.executor;

import java.io.File;


public interface Execution {

	String execute(String programCode);

	String execute(File programFile);

	Execution entryClass(String entryClass);

}