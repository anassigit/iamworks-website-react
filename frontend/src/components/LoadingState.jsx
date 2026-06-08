export default function LoadingState({ label = 'Loading experience...' }) {
  return (
    <div className="loading-state" role="status" aria-live="polite">
      <div className="spinner" />
      <p>{label}</p>
    </div>
  );
}
