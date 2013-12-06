package nl.avans.oopa.model;

import java.io.File;
import java.io.FilenameFilter;

class ClassFilenameFilter implements FilenameFilter
{
    public static final String sExtension = ".class";
    
    public boolean accept( File cFile, String name )
    {
        return name.endsWith( sExtension ) &&
               name.indexOf('$') == -1;
    }
}
