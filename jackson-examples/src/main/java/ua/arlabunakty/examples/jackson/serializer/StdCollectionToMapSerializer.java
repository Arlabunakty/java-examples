package ua.arlabunakty.examples.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Collection;

/**
 * Base class used for custom serializers collection into map.
 */
public abstract class StdCollectionToMapSerializer<T> extends StdSerializer<Collection<T>> {

    public StdCollectionToMapSerializer() {
        super((Class<Collection<T>>)null);
    }

    @Override
    public void serialize(Collection<T> collectionValue, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        for (T item : collectionValue) {
            gen.writeObjectField(getMapKey(item), getMapValue(item));
        }
        gen.writeEndObject();
    }

    /**
     * @see JsonGenerator#writeObject(Object)
     */
    protected abstract Object getMapValue(T value);

    /**
     * @see JsonGenerator#writeFieldName(String)
     */
    protected abstract String getMapKey(T value);

}
