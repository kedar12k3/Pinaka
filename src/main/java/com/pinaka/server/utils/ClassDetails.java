package com.pinaka.server.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import net.openhft.compiler.CachedCompiler;
import net.openhft.compiler.CompilerUtils;

public class ClassDetails {
	public Class<?> getClassn(String formName) throws IOException, ClassNotFoundException {
		/*CompilingClassLoader cclassLoader = new CompilingClassLoader();
		Class<?> className=null;
		try {
			className = cclassLoader.loadClass("forms.".concat(formName));
			System.out.println("CLASSLOADER: " + className.getClassLoader() +" ::" + className);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return className;*/
		//String modformName = "com.pinaka.server.entities." + formName;
		String modformName = "forms." + formName;
		String fileStub = modformName.replace( '.', '/' );

		// Build objects pointing to the source code (.java) and object
		// code (.class)
		String javaFilename = fileStub+".java";
		
		//File javaFile = new File(javaFilename);
		Class<?> theClass = null;
		//Class<?> aClass = null;
		try {
 			theClass = Class.forName(modformName);
		}
		catch(ClassNotFoundException ee) {
			if (theClass == null){
				String javaCode = new String(Files.readAllBytes(Paths.get(javaFilename)));
				File parent1 = new File(javaFilename).getParentFile();
				File parent = new File(parent1.getAbsolutePath()).getParentFile();
				System.out.println(parent.getAbsolutePath());
				CachedCompiler cachedCompiler = new CachedCompiler(new File(parent,"/build"), new File(parent,"/compiled")) ;
                theClass = cachedCompiler.loadFromJava(modformName, javaCode);     
				//theClass =  CompilerUtils.CACHED_COMPILER.loadFromJava(modformName, javaCode);
		}
		}
		System.out.println("CLASSLOADER: " + theClass.getClassLoader());
		return theClass;
	}
}
