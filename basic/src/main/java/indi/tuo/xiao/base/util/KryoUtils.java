package indi.tuo.xiao.base.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * KryoUtils
 */
public class KryoUtils {

  private static final ThreadLocal<Kryo> KRYO_THREAD_LOCAL = ThreadLocal
      .withInitial(KryoUtils::createKryo);

  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

  /**
   * create kryo serializer
   */
  private static Kryo createKryo() {
    Kryo kryo = new Kryo();
    kryo.addDefaultSerializer(LongAdder.class, new Serializer<LongAdder>() {
      @Override
      public void write(Kryo kryo, Output output, LongAdder object) {
        output.writeLong(object.sum());
      }

      @Override
      public LongAdder read(Kryo kryo, Input input, Class<? extends LongAdder> type) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(input.readLong());
        return longAdder;
      }
    });
    kryo.addDefaultSerializer(AtomicInteger.class, new Serializer<AtomicInteger>() {
      @Override
      public void write(Kryo kryo, Output output, AtomicInteger object) {
        output.writeInt(object.get());
      }

      @Override
      public AtomicInteger read(Kryo kryo, Input input, Class<? extends AtomicInteger> type) {
        return new AtomicInteger(input.readInt());
      }
    });
    return kryo;
  }

  /**
   * serialize object
   *
   * @param obj object
   * @return byte array
   */
  public static byte[] serialize(Object obj) {
    if (obj == null) {
      return EMPTY_BYTE_ARRAY;
    }
    Kryo kryo = KRYO_THREAD_LOCAL.get();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Output output = new Output(byteArrayOutputStream);
    kryo.writeClassAndObject(output, obj);
    output.flush();
    output.close();
    return byteArrayOutputStream.toByteArray();
  }

  /**
   * deserialize byte array
   *
   * @param bytes byte array
   * @param <T>   object type
   * @return object
   */
  public static <T> T deserialize(byte[] bytes) {
    if (bytes == null || bytes.length <= 0) {
      return null;
    }
    Kryo kryo = KRYO_THREAD_LOCAL.get();
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
    Input input = new Input(byteArrayInputStream);
    input.close();
    //noinspection unchecked
    return (T) kryo.readClassAndObject(input);
  }

  /**
   * deep clone object
   *
   * @param obj object
   * @param <T> object type
   * @return cloned object
   */
  public static <T> T copy(T obj) {
    if (Objects.isNull(obj)) {
      return null;
    }
    Kryo kryo = KRYO_THREAD_LOCAL.get();
    return kryo.copy(obj);
  }

  /**
   * To prevent memory leaks, please call remove after calling the KryoUtils method
   */
  public static void remove() {
    KRYO_THREAD_LOCAL.remove();
  }
}
