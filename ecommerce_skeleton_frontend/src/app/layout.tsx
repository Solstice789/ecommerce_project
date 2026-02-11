import { ReactNode } from "react";

export const metadata = {
  title: "ecommerce_skeleton_frontend",
  description: "Ecommerce skeleton frontend application - Products page"
};

export default function RootLayout({ children }: { children: ReactNode }) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
