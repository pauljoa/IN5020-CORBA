package TasteProfile;

/**
* TasteProfile/UserProfileHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./tasteprofile.idl
* Tuesday, 25 September 2018 14:32:55 o'clock CEST
*/

public final class UserProfileHolder implements org.omg.CORBA.portable.Streamable
{
  public TasteProfile.UserProfile value = null;

  public UserProfileHolder ()
  {
  }

  public UserProfileHolder (TasteProfile.UserProfile initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TasteProfile.UserProfileHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TasteProfile.UserProfileHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TasteProfile.UserProfileHelper.type ();
  }

}
