package TasteProfile;

/**
* TasteProfile/TopThreeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./tasteprofile.idl
* Tuesday, 18 September 2018 13:15:34 o'clock CEST
*/

public final class TopThreeHolder implements org.omg.CORBA.portable.Streamable
{
  public TasteProfile.TopThree value = null;

  public TopThreeHolder ()
  {
  }

  public TopThreeHolder (TasteProfile.TopThree initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TasteProfile.TopThreeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TasteProfile.TopThreeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TasteProfile.TopThreeHelper.type ();
  }

}
