package TasteProfile;


/**
* TasteProfile/SongProfileDefaultFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./tasteprofile.idl
* Tuesday, 18 September 2018 13:15:34 o'clock CEST
*/

public class SongProfileDefaultFactory implements org.omg.CORBA.portable.ValueFactory {

  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is)
  {
    return is.read_value(new SongProfileImpl ());
  }
}
