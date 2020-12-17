import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;

/**
 * Heather Whittlesey
 *	Sample XML program using SAX parsing.
 *
 * This example uses Breakfast class with inherited subclasses
 */


public class Main extends DefaultHandler {

    static GlassInventory glassProfile;
    static String currentTag;

    public void startDocument( ) throws SAXException {
        // System.out.println( "SAX Event: START DOCUMENT" );
        System.out.println("Importing an XML file and printing it.\n");

    }

    public void endDocument( ) throws SAXException {
        System.out.println( "\nEnd of the XML file." );
    }
    public void startElement( String namespaceURI, String localName, String qName, Attributes attr )
            throws SAXException
    {

        currentTag = localName;

        if(currentTag.equals("glassProfile")) {
            glassProfile =new GlassInventory();
        }

    }
    public void endElement( String namespaceURI, String localName, String qName )
            throws SAXException {
        // System.out.println( "SAX Event: END ELEMENT[ " + localName + " ]" );
        if(localName.equals("glassProfile")) {
            System.out.println(glassProfile);
        }
        currentTag = "";

    }
    public void characters( char[] ch, int start, int length )
            throws SAXException {

//	   	System.out.print( "SAX Event: CHARACTERS " );
        String value = new String(ch,start,length);

//	   	System.out.println( currentTag + " " + value  );
        if( currentTag.equals("inventoryID")) {
            glassProfile.setInventoryID(value);
        }
        if( currentTag.equals("colorName")) {
            glassProfile.setColorName(value);
        }
        if( currentTag.equals("supplyKg")) {
            glassProfile.setSupplyKg(Integer.parseInt(value));
        }
        if( currentTag.equals("physicalForm")) {
            glassProfile.setPhysicalForm(Integer.parseInt(value));

        }
        if( currentTag.equals("reducingProp")) {
            glassProfile.setReducingProp(value);

        }
        if( currentTag.equals("strikingProp")) {
            glassProfile.setStrikingProp(value);

        }
        if( currentTag.equals("colorTrans")) {
            glassProfile.setColorTrans(value);

        }
        if( currentTag.equals("adVenturine")) {
            glassProfile.setAdVenturine(value);

        }
        if( currentTag.equals("costPerKg")) {
            glassProfile.setCostPerKg(Double.parseDouble(value));

        }

    }
    // Constructor
    public Main()
    {
        try {
            // Create SAX 2 parser...
            XMLReader xr = XMLReaderFactory.createXMLReader();

            // Set the ContentHandler...
            xr.setContentHandler( this );

            // Parse the file...
            xr.parse( new InputSource( new FileReader( "reich.xml" )) );

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    public static void main( String[] argv )
    {
        //   System.out.println( "Example of SAX Events:" );
        Main ob = new Main();		// create object and call constructor.
    }
}
