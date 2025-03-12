--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4
-- Dumped by pg_dump version 16.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.status OWNER TO postgres;

--
-- Name: transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions (
    id character varying(255) NOT NULL,
    product_id character varying(255) NOT NULL,
    product_name character varying(255) NOT NULL,
    amount character varying(255) NOT NULL,
    customer_name character varying(255) NOT NULL,
    status integer NOT NULL,
    transaction_date timestamp without time zone,
    create_by character varying(255) NOT NULL,
    create_on timestamp without time zone
);


ALTER TABLE public.transactions OWNER TO postgres;

--
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.status (id, name) FROM stdin;
0	SUCCESS
1	FAILED
\.


--
-- Data for Name: transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions (id, product_id, product_name, amount, customer_name, status, transaction_date, create_by, create_on) FROM stdin;
1001	10001	Test 1	1000	abc	0	2022-07-10 11:14:52	abc	2022-07-10 11:14:52
1002	10002	Test 2	2000	abc	0	2022-07-11 13:14:52	abc	2022-07-10 13:14:52
1003	10001	Test 1	1000	abc	0	2022-08-10 12:14:52	abc	2022-07-10 12:14:52
1004	10002	Test 2	1000	abc	1	2022-08-10 13:10:52	abc	2022-07-10 13:10:52
1005	10001	Test 1	1000	abc	0	2022-08-10 13:11:52	abc	2022-07-10 13:11:52
1006	10002	Test 2	2000	abc	0	2022-08-12 13:14:52	abc	2022-07-10 13:14:52
1007	10001	Test 1	1000	abc	0	2022-08-12 14:11:52	abc	2022-07-10 14:11:52
1008	10002	Test 2	1000	abc	1	2022-09-13 11:14:52	abc	2022-07-10 11:14:52
1009	10001	Test 1	1000	abc	0	2022-09-13 13:14:52	abc	2022-07-10 13:14:52
1010	10002	Test 2	2000	abc	0	2022-09-14 09:11:52	abc	2022-07-10 09:11:52
1011	10001	Test 1	1000	abc	0	2022-09-14 10:14:52	abc	2022-07-10 10:14:52
1012	10002	Test 2	1000	abc	1	2022-08-15 13:14:52	abc	2022-07-10 13:14:52
\.


--
-- Name: status status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);


--
-- Name: transactions transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

