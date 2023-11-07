package com.martin.mysample.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@Slf4j
@Component
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(WRITE_DATES_AS_TIMESTAMPS, false);
        OBJECT_MAPPER.configure(FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.setSerializationInclusion(ALWAYS);
    }

    /**
     * 对象转化字符串
     *
     * @param object 对象
     * @return String
     */
    public static String toJSONString(Object object) {
        try {
            if (object == null) {
                return null;
            }
            if (object instanceof String) {
                return (String) object;
            }
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            log.debug("Object conversion String failed:{}", ExceptionUtils.getStackTrace(e));
        }
        return null;
    }

    /**
     * 对象转化字符串 格式化
     *
     * @param object 对象
     * @return String
     */
    public static String toJSONStringListOfPretty(Object object) {
        try {
            if (object == null) {
                return null;
            }
            // 配置四个空格的缩进
            DefaultPrettyPrinter.Indenter indenter = new DefaultIndenter("    ", DefaultIndenter.SYS_LF);
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
            printer.indentObjectsWith(indenter); // Indent JSON objects
            printer.indentArraysWith(indenter);  // Indent JSON arrays

            return OBJECT_MAPPER.writer(printer).writeValueAsString(object);
        } catch (Exception e) {
            log.debug("Object conversion String failed:{}", ExceptionUtils.getStackTrace(e));
        }
        return null;
    }

    /**
     * 对象转化字符串,返回异常信息
     *
     * @param object 对象
     * @return String
     * @throws JsonProcessingException 异常信息
     */
    public static String toJSONStringThrow(Object object) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(object);
    }

    /**
     * JSON字符串转化对象
     *
     * @param json  JSON字符串
     * @param clazz class
     * @param <T>   泛型
     * @return 返回对象
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            log.debug("String conversion Object failed:{}", ExceptionUtils.getStackTrace(e));
        }
        return null;
    }

    /**
     * JSON字符串转化对象
     *
     * @param json  JSON字符串
     * @param clazz class
     * @param <T>   class参数
     * @return class参数
     * @throws IOException 异常信息
     */
    public static <T> T parseObjectThrow(String json, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    /**
     * Json字符串转为Map对象
     *
     * @param json Json字符串
     * @return Map对象
     */
    public static Map<String, Object> parseObject(String json) {
        try {
            return OBJECT_MAPPER.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            log.debug("parse json string to object error, {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * Json字符串转为Map对象
     *
     * @param json Json字符串
     * @return Map对象
     * @throws IOException 异常信息
     */
    public static Map<String, Object> parseObjectThrow(String json) throws IOException {
        return OBJECT_MAPPER.readValue(json, new TypeReference<Map<String, Object>>() {
        });
    }

    /**
     * Json字符串转为指定类型对象
     *
     * @param json         Json字符串
     * @param valueTypeRef 类型
     * @return 对象
     */
    public static <T> T parseObject(String json, TypeReference<T> valueTypeRef) {
        try {
            return OBJECT_MAPPER.readValue(json, valueTypeRef);
        } catch (Exception e) {
            log.debug("parse json string to object error, {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * Json字符串转为指定类型对象
     *
     * @param json         Json字符串
     * @param valueTypeRef 类型
     * @return 对象
     * @throws IOException 异常信息
     */
    public static <T> T parseObjectThrow(String json, TypeReference<T> valueTypeRef) throws IOException {
        return OBJECT_MAPPER.readValue(json, valueTypeRef);
    }

    /**
     * Object对象转为指定类型对象
     *
     * @param object       Object对象
     * @param valueTypeRef 类型
     * @return 对象
     */
    public static <T> T parseObject(Object object, TypeReference<T> valueTypeRef) {
        try {
            return OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(object), valueTypeRef);
        } catch (Exception e) {
            log.debug("parse object to object error, {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * Object对象转为指定类型对象
     *
     * @param object       Object对象
     * @param valueTypeRef 类型
     * @return 对象
     * @throws IOException 异常信息
     */
    public static <T> T parseObjectThrow(Object object, TypeReference<T> valueTypeRef) throws IOException {
        return OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(object), valueTypeRef);
    }

    /***
     * Object对象转为JsonNode
     * @param object
     * @return JsonNode
     */
    public static JsonNode parseArray(Object object) {
        try {
            return  OBJECT_MAPPER.readTree(OBJECT_MAPPER.writeValueAsString(object));
        } catch (Exception e) {
            log.debug("parse object to array error, {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }


    public static List<Map<String, Object>> parseList(Object obj) {
        try {
            return OBJECT_MAPPER.readValue(toJSONString(obj), new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (Exception e) {
            log.debug("parse json string to object error, {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    public static <T> List<T> parseListT(Object obj, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(toJSONString(obj), getCollectionType(List.class, clazz));
        } catch (Exception e) {
            log.debug("parse json string to object error, {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }


}
