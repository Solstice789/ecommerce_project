"use client";

import { FormEvent, useEffect, useState } from "react";
import { createProduct, listProducts, Product } from "@/lib/api";

export default function HomePage() {
  const [products, setProducts] = useState<Product[]>([]);
  const [name, setName] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  async function loadProducts() {
    try {
      setLoading(true);
      setError("");
      const result = await listProducts();
      setProducts(result);
    } catch (err) {
      setError(err instanceof Error ? err.message : "An unknown error occurred");
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    void loadProducts();
  }, []);

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    try {
      setError("");
      await createProduct(name);
      setName("");
      await loadProducts();
    } catch (err) {
      setError(err instanceof Error ? err.message : "An unknown error occurred");
    }
  }

  return (
    <main style={{ padding: "20px", fontFamily: "sans-serif" }}>
      <div
        style={{
          maxWidth: "500px",
          margin: "0 auto",
          border: "1px solid #ccc",
          borderRadius: "8px",
          padding: "16px"
        }}
      >
        <h1>Ecommerce Product Page</h1>

        <form onSubmit={handleSubmit}>
          <label htmlFor="product-name">Product name</label>
          <br />
          <input
            id="product-name"
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            maxLength={255}
            required
          />
          <button type="submit" style={{ marginLeft: "8px" }}>
            Create Product
          </button>
        </form>

        {error && <p style={{ color: "red" }}>{error}</p>}

        <h2>Products</h2>
        {loading ? (
          <p>Loading...</p>
        ) : (
          <ul>
            {products.map((product) => (
              <li key={product.id}>
                {product.id} - {product.name}
              </li>
            ))}
          </ul>
        )}
      </div>
    </main>
  );
}
