
package com.httd.api.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局的事务处理
 * 
 * @author lsc
 *
 */
// 用于定义配置类，可替换xml配置文件 // 开启AspectJ 自动代理模式,如果不填proxyTargetClass=true，默认为false，

@Aspect
@Repository
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TransactionManagerConfig {

	private static final int TX_METHOD_TIMEOUT = 50000;

	private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.httd.api.business.*.service..*(..))";

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	public TransactionInterceptor txAdvice() {

		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		RuleBasedTransactionAttribute readOnlyRule = new RuleBasedTransactionAttribute();
		readOnlyRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
		readOnlyRule.setReadOnly(true);

		RuleBasedTransactionAttribute requireRule = new RuleBasedTransactionAttribute();
		requireRule.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		requireRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		requireRule.setTimeout(TX_METHOD_TIMEOUT);
		Map<String, TransactionAttribute> txMap = new HashMap<>(); // 添加事务
		txMap.put("save*", requireRule);
		txMap.put("delete*", requireRule);
		txMap.put("update*", requireRule);
		txMap.put("insert*", requireRule);
		txMap.put("exec*", requireRule);
		txMap.put("set*", requireRule);

		// 不加事务 txMap.put("get*", readOnlyRule); txMap.put("query*", readOnlyRule);
		txMap.put("find*", readOnlyRule);
		txMap.put("list*", readOnlyRule);
		txMap.put("count*", readOnlyRule);
		txMap.put("select*", readOnlyRule);
		source.setNameMap(txMap);
		return new TransactionInterceptor(transactionManager, source);
	}

	@Bean
	public Advisor txAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
		return new DefaultPointcutAdvisor(pointcut, txAdvice());
	}
}
