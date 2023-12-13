package com.luckk.lizzie.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.dump.MessageDumping;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author liukun.inspire
 * @Date 2023/12/13 16:39
 * @PackageName: com.luckk.lizzie.jackson
 * @ClassName: ObjectMapperTest
 * @Version 1.0
 */
// 吞吐量意味着1s可以执行的操作的次数
// averageTime 意味着一次需要的时间
@BenchmarkMode({Mode.AverageTime})
// 单位
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
// 预热与测量
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(10)
public class ObjectMapperTest {
    String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";

    // 全局共享的state
    @State(Scope.Benchmark)
    public static class BenchmarkState {
        ObjectMapper globalObjectMapper = new ObjectMapper();
        ThreadLocal<ObjectMapper> globalTheadLocal = new ThreadLocal<>();
    }

    // 待测试的方法，必须为public
    @Benchmark
    public Map defineInGloabal(BenchmarkState state) throws JsonProcessingException {
        return state.globalObjectMapper.readValue(json, Map.class);
    }

    @Benchmark
    public Map defineInThreadLocal(BenchmarkState state) throws JsonProcessingException {
        if (null == state.globalTheadLocal.get()) {
            state.globalTheadLocal.set(new ObjectMapper());
        }
        return state.globalTheadLocal.get().readValue(json, Map.class);
    }


    @Benchmark
    public Map defineInLocal() throws JsonProcessingException {
        ObjectMapper objectMapper1 = new ObjectMapper();
        Map map = objectMapper1.readValue(json, Map.class);
        return map;
    }

    /**
     * Benchmark                              Mode  Cnt         Score         Error  Units
     * ObjectMapperTest.defineInGloabal      thrpt    5  34595298.948 ± 3105027.786  ops/s
     * ObjectMapperTest.defineInLocal        thrpt    5   2066834.064 ± 1365924.537  ops/s
     * ObjectMapperTest.defineInThreadLocal  thrpt    5  31095234.806 ± 3053395.552  ops/s
     */
    public static void main(String[] args) throws RunnerException {

        Options opts = new OptionsBuilder()
                .include(ObjectMapperTest.class.getSimpleName())
                .resultFormat(ResultFormatType.CSV)
                .build();
        new Runner(opts).run();
    }
}
