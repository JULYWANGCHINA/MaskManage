package me.quantumti.utils;
//实现类  
import java.util.List;  
  
import javax.script.ScriptEngine;  
import javax.script.ScriptEngineManager;  
import javax.script.ScriptException;  
  
public class JavaScript {  
    ScriptEngineManager factory = new ScriptEngineManager();  
    ScriptEngine engine = factory.getEngineByName("JavaScript");  
      
    public double getMathValue(List<MapJ> map,String option){  
    	double d = 0;  
        try {  
            for(int i=0; i<map.size();i++){  
                MapJ mapj = map.get(i);  
                option = option.replaceAll(mapj.getKey(), mapj.getValue());  
            }  
            Object o = engine.eval(option);  
            d = Double.parseDouble(o.toString());  
        } catch (ScriptException e) {  
            System.out.println("无法识别表达式");  
        }  
        return d;  
    }  
}  
  
  