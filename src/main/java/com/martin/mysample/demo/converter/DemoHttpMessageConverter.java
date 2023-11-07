// package com.martin.myserver.demo.converter;
//
// import com.martin.mycommon.entity.dto.UserDTO;
// import org.springframework.http.HttpInputMessage;
// import org.springframework.http.HttpOutputMessage;
// import org.springframework.http.MediaType;
// import org.springframework.http.converter.HttpMessageConverter;
// import org.springframework.http.converter.HttpMessageNotReadableException;
// import org.springframework.http.converter.HttpMessageNotWritableException;
//
// import java.io.IOException;
// import java.io.OutputStream;
// import java.lang.reflect.Field;
// import java.util.ArrayList;
// import java.util.List;
//
// /**
//  * DemoHttpMessageConverter
//  *
//  * @author Martin
//  * @since 2023-10-29 17:04
//  **/
//
//
// public class DemoHttpMessageConverter implements HttpMessageConverter<UserDTO> {
//
//     @Override
//     public boolean canRead(Class<?> clazz, MediaType mediaType) {
//         return false;
//     }
//
//     /**
//      * 暂不考虑可读，只考虑可写
//      *
//      * @param clazz     the class to test for writability
//      * @param mediaType the media type to write (can be {@code null} if not specified);
//      *                  typically the value of an {@code Accept} header.
//      */
//     @Override
//     public boolean canWrite(Class<?> clazz, MediaType mediaType) {
//         // 判断转换前的类为指定类UserDTO
//         return clazz.isAssignableFrom(UserDTO.class);
//     }
//
//     /**
//      * 底层方法中需要统计该Converter可以转换哪些类型的数据格式
//      * application/demo
//      */
//     @Override
//     public List<MediaType> getSupportedMediaTypes() {
//         // 支持自定义数据格式application/demo
//         return MediaType.parseMediaTypes("application/demo");
//     }
//
//     @Override
//     public UserDTO read(Class<? extends UserDTO> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
//         return null;
//     }
//
//     /**
//      * 重写write方法，将数据转换为指定格式后以byte类型写入outputMessage的body中
//      *
//      * @param userDTO       the object to write to the output message. The type of this object must have previously been
//      *                      passed to the {@link #canWrite canWrite} method of this interface, which must have returned {@code true}.
//      * @param contentType   the content type to use when writing. May be {@code null} to indicate that the
//      *                      default content type of the converter must be used. If not {@code null}, this media type must have
//      *                      previously been passed to the {@link #canWrite canWrite} method of this interface, which must have
//      *                      returned {@code true}.
//      * @param outputMessage the message to write to
//      */
//     @Override
//     public void write(UserDTO userDTO, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
//         // 自定义协商数据格式
//         Field[] fields = userDTO.getClass().getDeclaredFields();
//         List<String> join = new ArrayList<>();
//         for (Field field : fields) {
//             field.setAccessible(true);
//             try {
//                 join.add(String.valueOf(field.get(userDTO)));
//             } catch (IllegalAccessException e) {
//                 throw new RuntimeException(e);
//             }
//         }
//         String result = String.join(";", join);
//
//         // 将转换后的数据转为Byte[]放入response中
//         OutputStream body = outputMessage.getBody();
//         body.write(result.getBytes());
//     }
// }
