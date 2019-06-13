# InputStreamToStringUtil
This class convert an InputStream to a String-without-BOM retrieving automatically the Charset (based on BOM bytes).

It reads the first bytes of the InputStream to retrieve the Charset (UTF). If no matches found, it use UTF-8.
