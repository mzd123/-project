package com.sc.domain.generator;

import java.util.ArrayList;
import java.util.List;

public class RadCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RadCodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCM_USERIDIsNull() {
            addCriterion("CM_USERID is null");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDIsNotNull() {
            addCriterion("CM_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDEqualTo(String value) {
            addCriterion("CM_USERID =", value, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDNotEqualTo(String value) {
            addCriterion("CM_USERID <>", value, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDGreaterThan(String value) {
            addCriterion("CM_USERID >", value, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDGreaterThanOrEqualTo(String value) {
            addCriterion("CM_USERID >=", value, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDLessThan(String value) {
            addCriterion("CM_USERID <", value, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDLessThanOrEqualTo(String value) {
            addCriterion("CM_USERID <=", value, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDLike(String value) {
            addCriterion("CM_USERID like", value, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDNotLike(String value) {
            addCriterion("CM_USERID not like", value, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDIn(List<String> values) {
            addCriterion("CM_USERID in", values, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDNotIn(List<String> values) {
            addCriterion("CM_USERID not in", values, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDBetween(String value1, String value2) {
            addCriterion("CM_USERID between", value1, value2, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_USERIDNotBetween(String value1, String value2) {
            addCriterion("CM_USERID not between", value1, value2, "CM_USERID");
            return (Criteria) this;
        }

        public Criteria andCM_CODEIsNull() {
            addCriterion("CM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCM_CODEIsNotNull() {
            addCriterion("CM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCM_CODEEqualTo(Integer value) {
            addCriterion("CM_CODE =", value, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODENotEqualTo(Integer value) {
            addCriterion("CM_CODE <>", value, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODEGreaterThan(Integer value) {
            addCriterion("CM_CODE >", value, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODEGreaterThanOrEqualTo(Integer value) {
            addCriterion("CM_CODE >=", value, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODELessThan(Integer value) {
            addCriterion("CM_CODE <", value, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODELessThanOrEqualTo(Integer value) {
            addCriterion("CM_CODE <=", value, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODEIn(List<Integer> values) {
            addCriterion("CM_CODE in", values, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODENotIn(List<Integer> values) {
            addCriterion("CM_CODE not in", values, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODEBetween(Integer value1, Integer value2) {
            addCriterion("CM_CODE between", value1, value2, "CM_CODE");
            return (Criteria) this;
        }

        public Criteria andCM_CODENotBetween(Integer value1, Integer value2) {
            addCriterion("CM_CODE not between", value1, value2, "CM_CODE");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}