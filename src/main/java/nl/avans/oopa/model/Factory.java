package nl.avans.oopa.model;
import java.util.Hashtable;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import java.io.FilenameFilter;
import java.security.ProtectionDomain;
import java.security.CodeSource;
import nl.avans.oopa.model.Node;

public class Factory {
	
	private Hashtable<String,Node> nodes;
    private static final String m_sSubDir = "gates";
	private static Factory instance;

	private Factory(){
		nodes = new Hashtable<String, Node>();
	}
	
	public static Node create(String id){
		Node node = instance().nodes.get(id);
		if(node == null)
			return null;
		else
			return node.copy();
	}
	
	public static void assing(String ID, Node node){
		instance().nodes.put(ID, node);
	}
	
	private static Factory instance(){
		if(instance == null){
			instance = new Factory();
			
			instance.initialize();
		}
		return instance;
	}
	
	private void initialize(){
        String sDir = getDirectory();
        loadClasses( sDir );
	}

	private void loadClasses(String sDir) {
        try
        {
            File           cFile   = new File( sDir );
            FilenameFilter cFilter = new ClassFilenameFilter();
            String[]       cList   = cFile.list( cFilter );
            int            nSize;
            String         sName;

            sDir    = getSubDir();
            for ( int n=0; n<cList.length; n++ )
            {
            	nSize   = cList[n].indexOf( '$' );
            	if ( nSize == -1 )
            	{
	                nSize   = cList[n].indexOf( '.' );
    	            sName   = cList[n].substring( 0, nSize );

        	        Class.forName( sDir+"."+sName );
            	}
            }
        }
        catch( Exception exception )
        {
            System.out.println( "error in loading files" );
        }
	}

	@SuppressWarnings("rawtypes")
	private String getDirectory() {
        final Class  cls           = getClass();
        URL          result        = null;
        final String clsAsResource = cls.getName().replace ('.','/').concat (".class");

        final ProtectionDomain pd = cls.getProtectionDomain ();
        // java.lang.Class contract does not specify if 'pd' can ever be null;
        // it is not the case for Sun's implementations, but guard against null
        // just in case:
        if (pd != null)
        {
            final CodeSource cs = pd.getCodeSource();
            // 'cs' can be null depending on the classloader behavior:
            if (cs != null)
                result = cs.getLocation();

            if (result != null)
            {
                // Convert a code source location into a full class file location
                // for some common cases:
                if (result.getProtocol().equals("file"))
                {
                    try
                    {
                        if (result.toExternalForm ().endsWith (".jar") ||
                            result.toExternalForm ().endsWith (".zip"))
                        {
                            result = new URL("jar:".concat(result.toExternalForm())
                                .concat("!/").concat (clsAsResource));
                        }
                        else
                        {
                            if ( new File(result.getFile()).isDirectory() )
                                result = new URL (result, clsAsResource);
                        }
                    }
                    catch (MalformedURLException ignore) {}
                }
            }
        }

        if (result == null)
        {
            // Try to find 'cls' definition as a resource; this is not
            // documented to be legal, but Sun's implementations seem to allow this:
            final ClassLoader clsLoader = cls.getClassLoader();
           
            result = clsLoader != null ?
                clsLoader.getResource (clsAsResource) :
                ClassLoader.getSystemResource(clsAsResource);
        }

        String  value   = "";
        if ( result != null )
        {
            value   = getSubDir().replace( '.', '/' ) + '/';
            value   = result.toString() + value;
            value   = replace( value, "%20", " " );
            value   = replace( value, "file:/", "" );
            //added this, else path isn't correct. Not sure how to fix...
            value   = replace( value, clsAsResource, "");
        }

        return value;
	}

    private String replace( String sText, String sOldText, String sNewText )
    {
        int     position    = 0,
                newPosition,
                step        = sOldText.length();
        String  sResult     = "";

        while ( (newPosition = sText.indexOf(sOldText,position)) >= 0 )
        {
            sResult    += sText.substring( position, newPosition );
            sResult    += sNewText;
            position    = newPosition + step;
        }
        sResult    += sText.substring( position );
        return sResult;
    }

    @SuppressWarnings("rawtypes")
	private String getSubDir()
    {
        final Class  cls           = getClass();
        final String clsAsResource = cls.getName();
        int          nPosition     = clsAsResource.lastIndexOf( '.' );

        if ( nPosition < 0 )
            return m_sSubDir;
        else
            return clsAsResource.substring( 0, nPosition+1 ) + m_sSubDir;
    }

}
